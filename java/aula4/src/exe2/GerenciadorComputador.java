package exe2;

import java.util.Scanner;

public class GerenciadorComputador {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        Computador comp1 = new Computador();
        
        System.out.println("--- Cadastro do Primeiro Computador ---");
        System.out.print("Digite a marca: ");
        comp1.marca = leitor.nextLine();
        
        System.out.print("Digite o modelo: ");
        comp1.modelo = leitor.nextLine();
        
        System.out.print("Digite o tipo (Notebook, Tablet, etc): ");
        comp1.tipo = leitor.nextLine();
        
        System.out.print("Digite o preço: ");
        comp1.preco = leitor.nextDouble();

        Computador comp2 = new Computador();
        comp2.marca = "Apple";
        comp2.modelo = "MacBook Air M2";
        comp2.tipo = "Notebook";
        comp2.preco = 8500.00;

        System.out.println("\n=== RESULTADOS DOS COMPUTADORES ===");
        
        System.out.println("Computador 1 (Usuário):");
        comp1.exibirInformacoes();
        
        System.out.println("Computador 2 (Código-fonte):");
        comp2.exibirInformacoes();

        leitor.close();
    }
}