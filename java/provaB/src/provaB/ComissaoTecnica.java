package provaB;

public class ComissaoTecnica extends Profissional {

    private static final double BONUS_POR_VITORIA = 300.0;

    public ComissaoTecnica(String nome,
                           int id,
                           double salarioBase)
            throws OrcamentoException {

        super(nome, id, salarioBase);
    }

    @Override
    public void registrarDesempenho(int vitorias) {

        if (vitorias > 0) {
            bonus += vitorias * BONUS_POR_VITORIA;
        }
    }

    @Override
    public String toString() {
        return "\n COMISSÃO TÉCNICA " + super.toString();
    }
}