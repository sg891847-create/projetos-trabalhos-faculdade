package exe11;

public class ItemMenu {
    protected String nome;
    protected double preco;

    public ItemMenu(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public void exibirItem() {
        System.out.println("Item: " + nome + " | Preço: R$ " + String.format("%.2f", preco));
    }
}
