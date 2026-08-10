package exe3;

public class Carro extends Veiculo {
    
    public void acelerar(int incremento) {
        this.velocidade += incremento;
        System.out.println("Acelerando vrummmmm...");
    }
}