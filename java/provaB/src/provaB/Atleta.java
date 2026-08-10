package provaB;

public class Atleta extends Profissional {

    private static final double BONUS_POR_GOL = 500.0;

    public Atleta(String nome, int id, double salarioBase)
            throws OrcamentoException {

        super(nome, id, salarioBase);
    }

    @Override
    public void registrarDesempenho(int gols) {

        if (gols > 0) {
            bonus += gols * BONUS_POR_GOL;
        }
    }

    @Override
    public String toString() {
        return "\n ATLETA " + super.toString();
    }
}