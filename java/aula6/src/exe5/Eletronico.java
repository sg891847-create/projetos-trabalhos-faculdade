package exe5;

public class Eletronico extends Produto {
    private int garantiaMeses;

    public Eletronico(String nome, double preco, int garantiaMeses) {
        super(nome, preco); 
        this.garantiaMeses = garantiaMeses;
    }

    @Override
    public void exibirDetalhes() {
        super.exibirDetalhes(); 
        System.out.println("Garantia: " + garantiaMeses + " meses");
    }
}
