package exe2;


public class Main {
 public static void main(String[] args) {
     ContaCorrente conta = new ContaCorrente("Alex Medeiros");

     System.out.println("--- Efetuando Depósito Válido ---");
     conta.depositar(100.0);
     System.out.println("Saldo atual: R$ " + conta.getSaldo());

     System.out.println("\n--- Testando Saque Maior que o Saldo ---");
     try {
         conta.sacar(150.0); 
     } catch (SaldoInsuficienteException e) {
         System.err.println("Exceção capturada: " + e.getMessage());
     }

     System.out.println("\n--- Testando Depósito Negativo ---");
     try {
         conta.depositar(-20.0);
     } catch (IllegalArgumentException e) {
         System.err.println("Exceção capturada: " + e.getMessage());
     }
 }
}
