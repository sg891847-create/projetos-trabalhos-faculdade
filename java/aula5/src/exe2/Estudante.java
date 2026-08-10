package exe2;

public class Estudante {
    private double nota;

    public Estudante() {
        this.nota = 0.0;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        if (nota > 0 && nota < 10) {
            this.nota = nota;
        } else {
            System.out.println("Nota inválida! A nota deve ser maior que 0 e menor que 10.");
        }
    }
}