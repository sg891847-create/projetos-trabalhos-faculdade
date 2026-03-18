package exe3;
import java.util.Scanner;

public class MediaAlunos {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        
        double[] notas = new double[5];
        double soma = 0;

        for (int i = 0; i < notas.length; i++) {
            System.out.print("Digite a nota do aluno " + (i + 1) + ": ");
            notas[i] = input.nextDouble();
            soma += notas[i]; 
        }

        double media = soma / notas.length;

        System.out.println("\n--- Resultado ---");
        System.out.printf("A média das notas dos 5 alunos é: %.2f%n", media);

        input.close();
    }
}