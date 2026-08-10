package exe3;

public class Veiculo {
    protected int velocidade;

    public Veiculo() {
        this.velocidade = 0;
    }

    public void mostrarVelocidade() {
        System.out.println("Velocidade atual: " + velocidade + " km/h");
    }
}