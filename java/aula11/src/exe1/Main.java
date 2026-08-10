package exe1;

public class Main {
    public static void main(String[] args) {
        Voo meuVoo = new Voo("G3-1542", "Rio de Janeiro");

        System.out.println("Voo: " + meuVoo.getNumeroDoVoo() + " | Destino: " + meuVoo.getDestino());
        System.out.println("--------------------------------------------------");

        try {
            meuVoo.reservarAssento(25);
        } catch (AssentoOcupadoException e) {
            System.err.println(e.getMessage());
        }

        try {
            meuVoo.reservarAssento(25);
        } catch (AssentoOcupadoException e) {
            System.err.println(e.getMessage());
        }

        try {
            meuVoo.reservarAssento(101);
        } catch (IllegalArgumentException e) {
            System.err.println("Erro de Argumento: " + e.getMessage());
        } catch (AssentoOcupadoException e) {
            System.err.println(e.getMessage());
        }
    }
}
