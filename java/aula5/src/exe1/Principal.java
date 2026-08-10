package exe1;

public class Principal {
    public static void main(String[] args) {
        ContaBancaria conta = new ContaBancaria();

        conta.setSaldo(500.0);
        conta.setLimite(200.0);

        System.out.println("Saldo inicial: R$ " + conta.getSaldo());
        System.out.println("Limite atual: R$ " + conta.getLimite());
        System.out.println("------------------------------------");

        conta.sacar(600.0); 
        System.out.println("Saldo após saque: R$ " + conta.getSaldo()); // Deve ficar -100

        conta.sacar(150.0); 

        conta.setLimite(-50.0);
    }
}