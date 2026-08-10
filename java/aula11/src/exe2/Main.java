package exe2;

public class Main {
    public static void main(String[] args) {
        Pedido meuPedido = new Pedido();

        ItemCardapio prato = new PratoPrincipal("Lasanha", 45.0, 30);
        ItemCardapio suco = new Bebida("Suco de Laranja", 10.0, false);
        ItemCardapio vinho = new Bebida("Vinho Tinto", 80.0, true);

        meuPedido.adicionarItem(prato);
        meuPedido.adicionarItem(suco);
        meuPedido.adicionarItem(vinho);

        double totalFinal = meuPedido.fecharConta();

        System.out.println("--- Resumo do Pedido ---");
        System.out.println("Item: Lasanha | Preço: R$ 45.00");
        System.out.println("Item: Suco (Não alcoólico) | Preço: R$ 10.00");
        System.out.println("Item: Vinho (Alcoólico + 10%) | Preço: R$ 88.00");
        System.out.println("------------------------");
        System.out.printf("Total da Conta: R$ %.2f%n", totalFinal);
    }
}
