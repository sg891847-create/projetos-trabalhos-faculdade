package calculadora;

/**
 * Modelo para armazenar os dados do sistema linear.
 * Atende aos requisitos de Definição do Sistema e Parâmetros de Controle.
 */
public class MatrixSystem {
    public double[][] A;
    public double[] b;
    public double tolerance;
    public int maxIterations;

    public MatrixSystem(double[][] A, double[] b, double tolerance, int maxIterations) {
        this.A = A;
        this.b = b;
        this.tolerance = tolerance;
        this.maxIterations = maxIterations;
    }
}