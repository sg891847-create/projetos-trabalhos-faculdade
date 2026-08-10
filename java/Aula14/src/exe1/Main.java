package exe1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Produto> carrinho = new ArrayList<>();
        
        System.out.println("--- Bem-vindo ao Sistema de E-commerce ---");
        
        while (true) {
            System.out.print("\nDeseja adicionar um produto? (s/n): ");
            String resposta = scanner.nextLine().trim().toLowerCase();
            
            if (resposta.equals("n")) {
                break;
            }
            
            System.out.print("Digite o nome do produto: ");
            String nome = scanner.nextLine();
            
            System.out.print("Digite o tipo do produto (1 - Físico / 2 - Digital): ");
            int tipo = Integer.parseInt(scanner.nextLine());
            
            double preco = 0;
            Produto produto = null;
            
            
            try {
                System.out.print("Digite o preço do produto: ");
                preco = Double.parseDouble(scanner.nextLine());
                
                if (tipo == 1) {
                    produto = new ProdutoFisico(nome, preco);
                } else if (tipo == 2) {
                    produto = new ProdutoDigital(nome, preco);
                } else {
                    System.out.println("Tipo inválido. Produto não adicionado.");
                    continue;
                }
                
                carrinho.add(produto);
                
            } catch (IllegalArgumentException e) {
                System.out.println("Erro ao definir preço: " + e.getMessage());
                continue; 
                }
            
            try {
                System.out.print("Digite uma nota de avaliação (1 a 5): ");
                int nota = Integer.parseInt(scanner.nextLine());
                
                if (produto instanceof Avaliavel) {
                    ((Avaliavel) produto).adicionarAvaliacao(nota);
                }
            } catch (NotaInvalidaException e) {
                System.out.println("Erro na avaliação: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Erro inesperado na leitura da nota.");
            }
        }
        
        System.out.println("\n--- Resumo do Carrinho ---");
        double totalProdutos = 0;
        double totalFrete = 0;
        
        for (Produto p : carrinho) {
            double frete = p.calcularFrete();
            System.out.printf("- %s | Preço: R$ %.2f | Frete: R$ %.2f\n", p.getNome(), p.getPreco(), frete);
            totalProdutos += p.getPreco();
            totalFrete += frete;
        }
        
        double totalCompra = totalProdutos + totalFrete;
        System.out.println("-----------------------------------");
        System.out.printf("Total dos Produtos: R$ %.2f\n", totalProdutos);
        System.out.printf("Total do Frete: R$ %.2f\n", totalFrete);
        System.out.printf("Total Geral da Compra: R$ %.2f\n", totalCompra);
        
        scanner.close();
    }
}