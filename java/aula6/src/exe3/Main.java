package exe3;

public class Main {
    public static void main(String[] args) {
        Carro meuCarro = new Carro();

        meuCarro.mostrarVelocidade(); 
        meuCarro.acelerar(500);        
        meuCarro.mostrarVelocidade(); 
    }
}
