package exe8;

import java.util.Scanner;

public class ContadorParesImpares {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] numeros = new int[10];
        int pares = 0;
        int impares = 0;

        System.out.println("Digite 10 números inteiros:");
        for (int i = 0; i < numeros.length; i++) {
            System.out.print((i + 1) + "º número: ");
            numeros[i] = input.nextInt();
        }

        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] % 2 == 0) {
                pares++;             
                } else {
                impares++; 
            }
        }

        System.out.println("\n--- Resumo da Contagem ---");
        System.out.println("Quantidade de números PARES: " + pares);
        System.out.println("Quantidade de números ÍMPARES: " + impares);

        input.close();
    }
}
