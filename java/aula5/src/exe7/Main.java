package exe7;

public class Main {
    public static void main(String[] args) {
        Termometro term = new Termometro(25.0); 

        System.out.println("Temperatura em Celsius: " + term.getCelsius());
    
        System.out.println("Temperatura em Fahrenheit: " + term.getFahrenheit()); 
        
        term.setFahrenheit(32.0); 
        
        System.out.println("Nova temperatura em Celsius: " + term.getCelsius()); 
        
    }
}
