package sistemadeFolhadePagamentoHospitalar;

public abstract class FuncionarioHospital {
    private String nome;
    private String matricula;
    private double salarioBase;
    private int horasTrabalhadasMensais;

    public FuncionarioHospital(String nome, String matricula, double salarioBase) {
        this.nome = nome;
        this.matricula = matricula;
        setSalarioBase(salarioBase); 
        this.horasTrabalhadasMensais = 0;
    }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getMatricula() { return matricula; }
    public void setMatricula(String matricula) { this.matricula = matricula; }

    public double getSalarioBase() { return salarioBase; }
    
    public void setSalarioBase(double salarioBase) {
        if (salarioBase < 1412.00) {
            throw new ValorInvalidoException("Salário base não pode ser inferior ao mínimo legal.");
        }
        this.salarioBase = salarioBase;
    }

    public int getHorasTrabalhadasMensais() { return horasTrabalhadasMensais; }

    public void setHorasTrabalhadasMensais(int horas) {
        if (horas < 0 || horas > 300) {
            throw new ValorInvalidoException("Carga horária inválida. O limite humano é 300 horas.");
        }
        this.horasTrabalhadasMensais = horas;
    }

    public abstract double calcularSalarioFinal();

    public void exibirResumoMensal() {
        System.out.println("Nome: " + nome);
        System.out.println("Matrícula: " + matricula);
        System.out.println("Horas Trabalhadas: " + horasTrabalhadasMensais);
        System.out.printf("Salário Final: R$ %.2f\n", calcularSalarioFinal());
        System.out.println("-----------------------------");
    }
}