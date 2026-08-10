package exe2;

public class Main {
    public static void main(String[] args) {
        Estudante aluno = new Estudante();

        aluno.setNota(8.5);  
        System.out.println("Nota atual: " + aluno.getNota());

        aluno.setNota(15.0); 
        System.out.println("Nota após tentativa inválida: " + aluno.getNota());
        
        aluno.setNota(0);    
        
    }
}