package exe5;
import java.util.Scanner;
 
	public class Fatorial {
	
		public static void main(String[] args) {
			
			Scanner teclado = new Scanner(System.in);
			
			int acumulador = 1;
			int n;
			System.out.println("digite um intero: ");
			n = teclado.nextInt();
			System.out.println("inteiro digitado: " +n);
			teclado.close();
			
			for(int e = 1; e <= n; e++ ) {
				
				acumulador = acumulador * e;
		}
			System.out.println("o fatorial do numero digitado é: " + acumulador);
	}
}
