/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package atividadeistemasdistribuidos.controller;

import atividadeistemasdistribuidos.model.Pessoa;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

public class ServidorController {

    private final int porta;
    private final List<Pessoa> listaPessoas;
    private boolean rodando = false;

    public ServidorController(int porta) {
        this.porta = porta;
        this.listaPessoas = Collections.synchronizedList(new ArrayList<>());
    }

    public ServidorController() {
        this(50000);
    }

    public void iniciarServidor(Consumer<String> onLog, Consumer<Pessoa> onNovoCadastro) {
        rodando = true;
        new Thread(() -> {
            try (ServerSocket servidor = new ServerSocket(porta)) {
                onLog.accept("Servidor iniciado e a ouvir na porta " + porta + "...");

                while (rodando) {
                    Socket cliente = servidor.accept();
                    new Thread(() -> tratarCliente(cliente, onLog, onNovoCadastro)).start();
                }
            } catch (Exception e) {
                if (rodando) {
                    onLog.accept("Erro no servidor: " + e.getMessage());
                }
            }
        }).start();
    }

    private void tratarCliente(Socket cliente, Consumer<String> onLog, Consumer<Pessoa> onNovoCadastro) {
        try {
            String ip = cliente.getInetAddress().getHostAddress();
            onLog.accept("Cliente conectado do IP: " + ip);

            try (ObjectInputStream entrada = new ObjectInputStream(cliente.getInputStream())) {
                Pessoa pessoaRecebida = (Pessoa) entrada.readObject();
                
                Pessoa pessoaRetorno = null;
                
                synchronized (listaPessoas) {
                    if (listaPessoas.contains(pessoaRecebida)) {
                        onLog.accept("Pessoa já cadastrada: " + pessoaRecebida.getNome());
                    } else {
                        String emailGerado = gerarEmail(pessoaRecebida.getNome(), pessoaRecebida.getDataNasc());
                        pessoaRetorno = new Pessoa(pessoaRecebida.getNome(), emailGerado, pessoaRecebida.getDataNasc());
                        
                        listaPessoas.add(pessoaRetorno);
                        onLog.accept("Nova pessoa cadastrada: " + pessoaRetorno.getNome() + " (" + emailGerado + ")");
                        onNovoCadastro.accept(pessoaRetorno);
                    }
                }
                
                try (ObjectOutputStream saida = new ObjectOutputStream(cliente.getOutputStream())) {
                    saida.flush();
                    saida.writeObject(pessoaRetorno);
                }
            }
            cliente.close();

        } catch (IOException | ClassNotFoundException e) {
            onLog.accept("Erro ao processar cliente: " + e.getMessage());
        }
    }

    private String gerarEmail(String nomeCompleto, String dataNasc) {
        String[] nomes = nomeCompleto.trim().toLowerCase().split("\\s+");
        String primeiroNome = nomes[0];
        String ultimoSobrenome = nomes.length > 1 ? nomes[nomes.length - 1] : "";

        String anoNascimento = "";
        if (dataNasc != null && dataNasc.contains("/")) {
            String[] partesData = dataNasc.split("/");
            anoNascimento = partesData[partesData.length - 1];
        } else {
            anoNascimento = dataNasc != null ? dataNasc.trim() : "";
        }

        if (ultimoSobrenome.isEmpty()) {
            return primeiroNome + "." + anoNascimento + "@ufn.edu.br";
        }
        return primeiroNome + "." + ultimoSobrenome + "." + anoNascimento + "@ufn.edu.br";
    }

    public List<Pessoa> getListaPessoas() {
        return Collections.unmodifiableList(listaPessoas);
    }
}