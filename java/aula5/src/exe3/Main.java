package exe3;

public class Main {
    public static void main(String[] args) {
        Retangulo meuRetangulo = new Retangulo(5.0, 3.0);

        System.out.println("A área é: " + meuRetangulo.getArea()); 

        meuRetangulo.setLargura(10.0);
        System.out.println("Nova área: " + meuRetangulo.getArea()); 
    }
}