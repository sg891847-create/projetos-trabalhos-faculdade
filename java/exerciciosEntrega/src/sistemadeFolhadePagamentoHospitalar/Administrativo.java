package sistemadeFolhadePagamentoHospitalar;

public class Administrativo extends FuncionarioHospital {
    private String departamento;
    private boolean cargoDeGestao;

    public Administrativo(String nome, String matricula, double salarioBase, String departamento, boolean cargoDeGestao) {
        super(nome, matricula, salarioBase);
        this.departamento = departamento;
        this.cargoDeGestao = cargoDeGestao;
    }

    @Override
    public double calcularSalarioFinal() {
        double bonusGestao = cargoDeGestao ? 1500.00 : 0.00;
        return getSalarioBase() + bonusGestao;
    }
}