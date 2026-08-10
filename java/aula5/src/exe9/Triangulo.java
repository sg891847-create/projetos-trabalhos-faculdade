package exe9;

public class Triangulo {
    private double ladoA;
    private double ladoB;
    private double ladoC;

    public Triangulo(double ladoA, double ladoB, double ladoC) {
        if (isValido(ladoA, ladoB, ladoC)) {
            this.ladoA = ladoA;
            this.ladoB = ladoB;
            this.ladoC = ladoC;
        } else {
            this.ladoA = 1;
            this.ladoB = 1;
            this.ladoC = 1;
            System.out.println("Valores iniciais inválidos. Criado triângulo padrão (1,1,1).");
        }
    }

    private boolean isValido(double a, double b, double c) {
        return (a + b > c) && (a + c > b) && (b + c > a);
    }

    public void setLadoA(double novoA) {
        if (isValido(novoA, this.ladoB, this.ladoC)) {
            this.ladoA = novoA;
        } else {
            System.out.println("Operação cancelada: O novo lado A invalidaria o triângulo.");
        }
    }

    public void setLadoB(double novoB) {
        if (isValido(this.ladoA, novoB, this.ladoC)) {
            this.ladoB = novoB;
        } else {
            System.out.println("Operação cancelada: O novo lado B invalidaria o triângulo.");
        }
    }

    public void setLadoC(double novoC) {
        if (isValido(this.ladoA, this.ladoB, novoC)) {
            this.ladoC = novoC;
        } else {
            System.out.println("Operação cancelada: O novo lado C invalidaria o triângulo.");
        }
    }

    public double getLadoA() { return ladoA; }
    public double getLadoB() { return ladoB; }
    public double getLadoC() { return ladoC; }
}