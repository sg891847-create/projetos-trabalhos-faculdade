package exe2;

public class Disciplina {

	public static void main(String[] args) {

		Professor p = new Professor();
		p.nome = "Ricardo da Silva";
		
		Laboratorio l = new Laboratorio();
		
		l.local = "sala 108";
		
		System.out.println("nome professor: " + p.nome);
		System.out.println("sala: " + l.local);
	}

}
