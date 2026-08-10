package exe6;

public class Cronometro {
    private int segundos;

    public Cronometro() {
        this.segundos = 0;
    }

    public void passarTempo() {
        this.segundos++;
    }

    public int getSegundos() {
        return segundos;
    }
    
    public void resetar() {
        this.segundos = 0;
    }
}
