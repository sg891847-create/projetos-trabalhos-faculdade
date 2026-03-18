package exe7;

import java.util.Scanner;

public class NotasMatriz {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        double[][] notas = new double[3][4];

        for (int aluno = 0; aluno < 3; aluno++) {
            System.out.println("Notas do Aluno " + (aluno + 1) + ":");
            for (int disc = 0; disc < 4; disc++) {
                System.out.print("  Disciplina " + (disc + 1) + ": ");
                notas[aluno][disc] = input.nextDouble();
            }
        }

        System.out.println("\n--- Análise por Disciplina ---");

        for (int disc = 0; disc < 4; disc++) {
            double maior = notas[0][disc];
            double menor = notas[0][disc];

            for (int aluno = 1; aluno < 3; aluno++) {
                if (notas[aluno][disc] > maior) {
                    maior = notas[aluno][disc];
                }
                if (notas[aluno][disc] < menor) {
                    menor = notas[aluno][disc];
                }
            }

            System.out.printf("Disciplina %d: Maior Nota = %.1f | Menor Nota = %.1f%n", 
                              (disc + 1), maior, menor);
        }

        input.close();
    }
}