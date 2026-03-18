package exe;

import java.util.Scanner;
public class Principal {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		int n;
		
		System.out.println("digite um intero: ");
		n = teclado.nextInt();
		System.out.println("inteiro digitado: " +n);
		double n2;
		System.out.println("digite um double: ");
		n2 = teclado.nextDouble();
		System.out.println("double digitado: " +n2);
		String palavra;
		System.out.println("digite a palavra: ");
		teclado.nextLine(); //limpa o buffer
		palavra = teclado.nextLine();
		System.out.println("palavra digitada: " +palavra);
		
		System.out.println("digite novamente");
		palavra = teclado.next();//pega ate o espaço 4 5 8 10	
		System.out.println("string digitada: " +palavra);
		
		teclado.close();
		}
}