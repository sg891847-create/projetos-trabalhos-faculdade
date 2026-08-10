package sistemadeFolhadePagamentoHospitalar;

public class Enfermeiro extends FuncionarioHospital {
    private String setor;
    private double percentualInsalubridade;

    public Enfermeiro(String nome, String matricula, double salarioBase, String setor) {
        super(nome, matricula, salarioBase);
        this.setor = setor;
    }

    public void setPercentualInsalubridade(double p) {
        if (p == 0.10 || p == 0.20 || p == 0.40) {
            this.percentualInsalubridade = p;
        } else {
            throw new ValorInvalidoException("Percentual de insalubridade não reconhecido pelo sindicato.");
        }
    }

    @Override
    public double calcularSalarioFinal() {
        double bonusInsalubridade = getSalarioBase() * percentualInsalubridade;
        double valorHorasExtra = 0;
        if (getHorasTrabalhadasMensais() > 160) {
            valorHorasExtra = (getHorasTrabalhadasMensais() - 160) * 50.00;
        }
        return getSalarioBase() + bonusInsalubridade + valorHorasExtra;
    }
}
