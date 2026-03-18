package exe8;

import java.util.Scanner;

public class SaoPaulo {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        String cidade = "";

        while (!cidade.equalsIgnoreCase("São Paulo")) {
            System.out.print("Digite o nome de uma cidade: ");
            cidade = teclado.nextLine();
            
            if (!cidade.equalsIgnoreCase("São Paulo")) {
            }
        }

        System.out.println("Encerrando...");
        teclado.close();
    }
}