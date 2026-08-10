package provaB;

public abstract class Profissional {

    private String nome;
    private int id;
    private double salarioBase;
    protected double bonus;

    public static final double TETO_SALARIAL = 50000.0;

    public Profissional(String nome, int id, double salarioBase)
            throws OrcamentoException {

        this.nome = nome;
        this.id = id;
        setSalarioBase(salarioBase);
        this.bonus = 0;
    }

    public String getNome() {
        return nome;
    }

    public int getId() {
        return id;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase)
            throws OrcamentoException {

        if (salarioBase < 0 || salarioBase > TETO_SALARIAL) {
            throw new OrcamentoException(
                    "Salário inválido meu chapa, Deve estar entre 0 e "
                            + TETO_SALARIAL);
        }

        this.salarioBase = salarioBase;
    }

    public double calcularPagamento() {
        return salarioBase + bonus;
    }

    public abstract void registrarDesempenho(int valor);

    @Override
    public String toString() {
        return "\nID: " + id +
                "\nNome: " + nome +
                "\nSalário Base: R$ " + salarioBase +
                "\nBônus: R$ " + bonus +
                "\nPagamento Final: R$ " + calcularPagamento();
    }
}