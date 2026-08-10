package exe4;

public class Livro {
    public String titulo;
    public String autor;
    public int anoPublicacao;

    public void exibirDetalhes() {
        System.out.println("\n--- Informações do Livro ---");
        System.out.println("Título: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("Ano de Publicação: " + anoPublicacao);
        System.out.println("----------------------------");
    }
}
