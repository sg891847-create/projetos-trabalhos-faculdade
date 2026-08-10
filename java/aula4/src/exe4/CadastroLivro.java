package exe4;

import java.util.Scanner;

public class CadastroLivro {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        
        Livro meuLivro = new Livro();

        System.out.println("### Cadastro de Novo Livro ###");

        System.out.print("Digite o título do livro: ");
        meuLivro.titulo = leitor.nextLine();

        System.out.print("Digite o autor: ");
        meuLivro.autor= leitor.nextLine();

        System.out.print("Digite o ano de publicação: ");
        meuLivro.anoPublicacao = leitor.nextInt();

        meuLivro.exibirDetalhes();

        leitor.close();
    }
}