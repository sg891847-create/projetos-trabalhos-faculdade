package calculadora;

/**
 * Motor matemático (Back-end) do projeto.
 */
public class LinearSolver {

    public static class Result {
        public double[] x;
        public int iterations;
        public String method;

        public Result(double[] x, int iterations, String method) {
            this.x = x;
            this.iterations = iterations;
            this.method = method;
        }
    }

    // Método Direto: Eliminação de Gauss com Pivoteamento Parcial
    public static Result solveGauss(double[][] A, double[] b) throws Exception {
        int n = b.length;
        for (int p = 0; p < n; p++) {
            int pivot = p;
            for (int i = p + 1; i < n; i++) {
                if (Math.abs(A[i][p]) > Math.abs(A[pivot][p])) pivot = i;
            }
            double[] temp = A[p]; A[p] = A[pivot]; A[pivot] = temp;
            double t = b[p]; b[p] = b[pivot]; b[pivot] = t;

            if (Math.abs(A[p][p]) <= 1e-15) throw new Exception("Matriz Singular!");

            for (int i = p + 1; i < n; i++) {
                double alpha = A[i][p] / A[p][p];
                b[i] -= alpha * b[p];
                for (int j = p; j < n; j++) A[i][j] -= alpha * A[p][j];
            }
        }
        double[] x = new double[n];
        for (int i = n - 1; i >= 0; i--) {
            double sum = 0;
            for (int j = i + 1; j < n; j++) sum += A[i][j] * x[j];
            x[i] = (b[i] - sum) / A[i][i];
        }
        return new Result(x, 0, "Eliminação de Gauss");
    }

    // Métodos Iterativos: Jacobi e Gauss-Seidel
    public static Result solveIterative(MatrixSystem sys, boolean isSeidel) throws Exception {
        int n = sys.b.length;
        double[] x = new double[n]; 
        
        for (int k = 1; k <= sys.maxIterations; k++) {
            double[] nextX = new double[n];
            double maxDiff = 0;

            for (int i = 0; i < n; i++) {
                double sum = 0;
                for (int j = 0; j < n; j++) {
                    if (i != j) {
                        double val = (isSeidel && j < i) ? nextX[j] : x[j];
                        sum += sys.A[i][j] * val;
                    }
                }
                if (Math.abs(sys.A[i][i]) < 1e-15) throw new Exception("Divisão por zero na diagonal.");
                nextX[i] = (sys.b[i] - sum) / sys.A[i][i];
                maxDiff = Math.max(maxDiff, Math.abs(nextX[i] - x[i]));
            }
            x = nextX.clone();
            if (maxDiff < sys.tolerance) return new Result(x, k, isSeidel ? "Gauss-Seidel" : "Jacobi");
        }
        throw new Exception("O sistema não convergiu (Excedeu iterações).");
    }
}