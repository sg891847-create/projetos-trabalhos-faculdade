package exe9;

public class Main {
    public static void main(String[] args) {
        Triangulo tri = new Triangulo(3, 4, 5); 
        
        tri.setLadoA(100); 
        
        System.out.println("Lado A continua sendo: " + tri.getLadoA()); // Saída: 3.0
    }
}
