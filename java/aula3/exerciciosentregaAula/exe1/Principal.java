package exe1;

import java.util.Scanner;

public class Principal {
public static void main(String[] args) {
	Carro c = new Carro();
	Scanner teclado = new Scanner(System.in);
	System.out.println("digite a marca do veiculo:");
	c.marca = teclado.nextLine();
	System.out.println("digite o modelo do veiculo:");
	c.modelo = teclado.nextLine();
	System.out.println("digite o ano de fabricação do veiculo");
	c.anoFabricacao = teclado.nextInt();
	teclado.nextLine();
	System.out.println("marca do carro: " +c.marca);
	System.out.println("modelo do carro: " +c.modelo);
	System.out.println("ano de fabricação do carro: " +c.anoFabricacao);
	
	Carro c2 = new Carro();
	System.out.println("digite a marca do veiculo:");
	c2.marca = teclado.nextLine();
	System.out.println("digite o modelo do veiculo:");
	c2.modelo = teclado.nextLine();
	System.out.println("digite o ano de fabricação do veiculo");
	c2.anoFabricacao = teclado.nextInt();
	teclado.nextLine();
	teclado.close();
	System.out.println("marca do carro: " +c2.marca);
	System.out.println("modelo do carro: " +c2.modelo);
	System.out.println("ano de fabricação do carro: " +c2.anoFabricacao);

	
	}
}
