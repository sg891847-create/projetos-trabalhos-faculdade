package exe6;

public class Forma {
    protected String cor;

    public Forma(String cor) {
        this.cor = cor;
    }

    public void exibirCor() {
        System.out.println("Cor da forma: " + cor);
    }
}
