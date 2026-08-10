package aula3exe;
import java.util.Scanner;
public class Principal {

	public static void main(String[] args) {
		Filme f = new Filme();
		System.out.println("primeiro filme:");
		f.titulo = "Jurassick Park";
		f.diretor = "Steven Spielberg";
		f.anoLançamento = 1993;
		f.genero ="Ação, Ficção científica, Aventura, Fantasia, Catástrofe, Suspense";
		System.out.println("titulo: " +f.titulo);
		System.out.println("diretor: " +f.diretor);
		System.out.println("ano de lançamento: " +f.anoLançamento);
		System.out.println("genero " +f.genero);
		
		Filme f2 = new Filme();
		f2.titulo = "E.T";
		f2.diretor = "Steven Spielberg";
		f2.anoLançamento = 1982;
		f2.genero ="ficção científica, drama e fantasia";
		System.out.println("segundo filme:");
		System.out.println("titulo: " +f2.titulo);
		System.out.println("diretor: " +f2.diretor);
		System.out.println("ano de lançamento: " +f2.anoLançamento);
		System.out.println("genero " +f2.genero);
		
		Filme f3 = new Filme();
		Scanner teclado = new Scanner(System.in);
		System.out.println("digite o titulo:");
		 f3.titulo = teclado.nextLine();
		 System.out.println("digite o diretor:");
		 f3.diretor = teclado.nextLine();
		 System.out.println("digite o ano:");
		 f3.anoLançamento = teclado.nextInt();
		 teclado.nextLine();
		 System.out.println("digite o genero: ");
		 f3.genero = teclado.nextLine();
		System.out.println("terceiro filme incerido pelo teclado:");
		System.out.println("titulo: " +f3.titulo);
		System.out.println("diretor: " +f3.diretor);
		System.out.println("ano de lançamento: " +f3.anoLançamento);
		System.out.println("genero: " +f3.genero);
		
		teclado.close();
	}

}

