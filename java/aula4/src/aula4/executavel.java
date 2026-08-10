package aula4;
import java.util.Scanner;

import java.util.Scanner;

public class executavel {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.print("Digite a quantidade de carros: ");
        int n = teclado.nextInt();

        Carro[] garagem = new Carro[n];

        for (int i = 0; i < n; i++) {
            garagem[i] = new Carro();
            
            teclado.nextLine();
            System.out.println("\n Cadastro do Carro \n" + "carro " + (i + 1));
            
            System.out.print("Marca: ");
            garagem[i].marca = teclado.nextLine();
            
            System.out.print("Modelo: ");
            garagem[i].modelo = teclado.nextLine();
            
            System.out.print("Ano: ");
            garagem[i].anoFabricacao = teclado.nextInt();
        }

        System.out.println("\n VEÍCULOS ARMAZENADOS \n");
        for (int i = 0; i < n; i++) {
            System.out.println("Carro " + (i + 1) + ": " + 
                    	garagem[i].marca + " " + 
                    	garagem[i].modelo + " (" + 
                        garagem[i].anoFabricacao + ")");
        }

        teclado.close();
    }
}