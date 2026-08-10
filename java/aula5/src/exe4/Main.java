package exe4;

public class Main {
    public static void main(String[] args) {
        Produto p1 = new Produto("Teclado Mecânico", 10);

        p1.adicionarEstoque(5); 
        System.out.println("Estoque: " + p1.getQuantidadeEmEstoque()); 
        p1.removerEstoque(20); 
        
        p1.removerEstoque(7); 
        System.out.println("Estoque final: " + p1.getQuantidadeEmEstoque()); 
        
    }
}
