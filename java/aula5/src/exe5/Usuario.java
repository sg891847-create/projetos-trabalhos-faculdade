package exe5;

public class Usuario {
    private String nome;
    private String senha;

    public Usuario(String nome, String senha) {
        this.nome = nome;
        setSenha(senha); 
        }

    public String getSenha() {
        if (this.senha == null) return "";
        
        return "*".repeat(this.senha.length());
    }

    public void setSenha(String novaSenha) {
        if (novaSenha != null && novaSenha.length() >= 8) {
            this.senha = novaSenha;
        } else {
            System.out.println("Erro: A senha deve ter no mínimo 8 caracteres.");
            if (this.senha == null) this.senha = "********"; 
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
