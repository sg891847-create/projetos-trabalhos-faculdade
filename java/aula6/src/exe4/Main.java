package exe4;
public class Main {
    public static void main(String[] args) {
        
        Funcionario funcComum = new Funcionario("Nero", 2500.00);
        
        Gerente gerente = new Gerente("Cayde", 5000.00);
        
        Vendedor vendedor = new Vendedor("Lence", 2000.00, 800.00);

        System.out.println("  Folha de Pagamento  ");
        
        System.out.println("Funcionário: " + funcComum.nome);
        System.out.println("Salário: R$ " + funcComum.calcularSalario());
        
        System.out.println("\nGerente: " + gerente.nome);
        System.out.println("Salário (Base + 20%): R$ " + gerente.calcularSalario());
        
        System.out.println("\nVendedor: " + vendedor.nome);
        System.out.println("Salário (Base + Comissão): R$ " + vendedor.calcularSalario());
    }
}