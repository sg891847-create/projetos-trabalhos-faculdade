package exe6;

import java.util.Scanner;

public class CidadesPopulacao {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        String[] cidades = new String[5];
        int[] populacoes = new int[5];

        for (int i = 0; i < 5; i++) {
            System.out.print("Digite o nome da " + (i + 1) + "ª cidade: ");
            cidades[i] = input.nextLine();
            
            System.out.print("Digite a população de " + cidades[i] + ": ");
            populacoes[i] = input.nextInt();
            input.nextLine();
        }

        int maiorPop = populacoes[0];
        int indiceMaior = 0;

        for (int i = 1; i < populacoes.length; i++) {
            if (populacoes[i] > maiorPop) {
                maiorPop = populacoes[i];
                indiceMaior = i; 
            }
        }

        System.out.println("\n--- Cidade Mais Populosa ---");
        System.out.println("Cidade: " + cidades[indiceMaior]);
        System.out.println("População: " + maiorPop + " habitantes");

        input.close();
    }
}
