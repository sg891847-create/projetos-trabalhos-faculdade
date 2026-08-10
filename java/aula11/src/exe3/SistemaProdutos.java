package exe3;

import java.util.ArrayList;
import java.util.List;

public class SistemaProdutos {
    public static void main(String[] args) {
        List<Produto> carrinho = new ArrayList<>();

        carrinho.add(new Eletronico("Smartphone", 2000.0));
        carrinho.add(new Vestuario("Camiseta Algodão", 100.0));
        carrinho.add(new Alimento("Arroz 5kg", 30.0));
        carrinho.add(new Eletronico("Fone Bluetooth", 300.0));

        try {
            carrinho.get(0).aplicarDesconto(10); 
            carrinho.get(2).aplicarDesconto(60); 
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }

        double totalImpostos = 0;

        System.out.println("\n--- Resumo de Tributação ---");
        for (Produto p : carrinho) {
            if (p instanceof Tributavel) {
                Tributavel itemTributado = (Tributavel) p; 
                double imposto = itemTributado.calcularImposto();
                totalImpostos += imposto;
                
                System.out.printf("Produto: %s | Valor: R$ %.2f | Imposto: R$ %.2f%n", 
                    p.getDescricao(), p.getValorOriginal(), imposto);
            } else {
                System.out.println("Produto: " + p.getDescricao() + " | ISENTO");
            }
        }

        System.out.println("----------------------------------");
        System.out.printf("Total de Impostos a Pagar: R$ %.2f%n", totalImpostos);
    }
}