/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package atividadeistemasdistribuidos.model;

import java.io.Serializable;
import java.util.Objects;

public class Pessoa implements Serializable {
    private static final long serialVersionUID = 1L;

    private String nome;
    private String email;
    private String dataNasc;

    // Construtor enviado pelo Cliente
    public Pessoa(String nome, String dataNasc) {
        this.nome = nome;
        this.dataNasc = dataNasc;
    }

    // Construtor completo gerado pelo Servidor
    public Pessoa(String nome, String email, String dataNasc) {
        this.nome = nome;
        this.email = email;
        this.dataNasc = dataNasc;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(String dataNasc) {
        this.dataNasc = dataNasc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pessoa pessoa = (Pessoa) o;
        return Objects.equals(nome != null ? nome.trim().toLowerCase() : null,
                              pessoa.nome != null ? pessoa.nome.trim().toLowerCase() : null) &&
               Objects.equals(dataNasc != null ? dataNasc.trim() : null,
                              pessoa.dataNasc != null ? pessoa.dataNasc.trim() : null);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            nome != null ? nome.trim().toLowerCase() : null,
            dataNasc != null ? dataNasc.trim() : null
        );
    }

    @Override
    public String toString() {
        return "Pessoa{" + "nome='" + nome + '\'' + ", email='" + email + '\'' + ", dataNasc='" + dataNasc + '\'' + '}';
    }
}