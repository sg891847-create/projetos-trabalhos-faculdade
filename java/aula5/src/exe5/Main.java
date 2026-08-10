package exe5;

public class Main {
    public static void main(String[] args) {
        Usuario user = new Usuario("Admin", "12345678");

        user.setSenha("123"); 
        
        System.out.println("Usuário: " + user.getNome());
        System.out.println("Senha: " + user.getSenha()); 
        
    }
}