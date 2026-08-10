package exe10;

public class Main {
    public static void main(String[] args) {
        Instrumento meuViolao = new Violao();
        Instrumento meuPiano = new Piano();

        System.out.println("  Orquestra Iniciando  ");
        
        meuViolao.tocar();         
        meuPiano.tocar();  
        }
}