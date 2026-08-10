package exe2;

public abstract class ItemCardapio {
    protected String nome;
    protected double precoBase;

    public ItemCardapio(String nome, double precoBase) {
        this.nome = nome;
        this.precoBase = precoBase;
    }

    public abstract double calcularPrecoFinal();

    public String getNome() {
        return nome;
    }
}
