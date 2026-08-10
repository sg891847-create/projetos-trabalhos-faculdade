package exe1;

public class AssentoOcupadoException extends Exception {
    public AssentoOcupadoException(int numeroAssento) {
        super("Erro: O assento " + numeroAssento + " já está reservado.");
    }
}