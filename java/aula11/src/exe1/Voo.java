package exe1;

public class Voo {
    private String numeroDoVoo;
    private String destino;
    private boolean[] assentos;

    public Voo(String numeroDoVoo, String destino) {
        this.numeroDoVoo = numeroDoVoo;
        this.destino = destino;
        this.assentos = new boolean[100]; 
        }

    public String getNumeroDoVoo() {
        return numeroDoVoo;
    }

    public String getDestino() {
        return destino;
    }

    public void reservarAssento(int numeroAssento) throws AssentoOcupadoException {
        if (numeroAssento < 1 || numeroAssento > 100) {
            throw new IllegalArgumentException("Número de assento inválido! Escolha entre 1 e 100.");
        }

        int indice = numeroAssento - 1;

        if (assentos[indice]) {
            throw new AssentoOcupadoException(numeroAssento);
        }

        assentos[indice] = true;
        System.out.println("Assento " + numeroAssento + " reservado com sucesso para o voo " + numeroDoVoo);
    }
}