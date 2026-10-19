/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package atividadeistemasdistribuidos.controller;

import atividadeistemasdistribuidos.model.Pessoa;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.function.Consumer;

public class ClienteController {

    private final String host;
    private final int porta;

    public ClienteController(String host, int porta) {
        this.host = host;
        this.porta = porta;
    }

    public ClienteController() {
        this("localhost", 50000);
    }

    public void enviarPessoaAsync(Pessoa pessoaObjeto, Consumer<Pessoa> onSuccess, Consumer<String> onError) {
        new Thread(() -> {
            try (Socket socket = new Socket(host, porta);
                 ObjectOutputStream saida = new ObjectOutputStream(socket.getOutputStream())) {

                saida.flush();
                saida.writeObject(pessoaObjeto);

                try (ObjectInputStream entrada = new ObjectInputStream(socket.getInputStream())) {
                    Pessoa pessoaRetorno = (Pessoa) entrada.readObject();

                    if (pessoaRetorno != null) {
                        onSuccess.accept(pessoaRetorno);
                    } else {
                        onError.accept("Esta pessoa já se encontra cadastrada no servidor!");
                    }
                }
            } catch (Exception ex) {
                onError.accept("Erro ao comunicar com o servidor: " + ex.getMessage());
            }
        }).start();
    }
}