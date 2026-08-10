package exe6;

public class Circulo extends Forma {
    private double raio;

    public Circulo(String cor, double raio) {
        super(cor); 
        this.raio = raio;
    }

    public void exibirDados() {
        System.out.println("Forma: Círculo");
        System.out.println("Cor: " + cor);
        System.out.println("Raio: " + raio);
    }
}
