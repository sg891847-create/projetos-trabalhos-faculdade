package exe6;

public class Main {
    public static void main(String[] args) {
        Cronometro meuCronometro = new Cronometro();

        meuCronometro.passarTempo();
        meuCronometro.passarTempo();
        meuCronometro.passarTempo();

        System.out.println("Tempo decorrido: " + meuCronometro.getSegundos() + "s"); 
 
    }
}