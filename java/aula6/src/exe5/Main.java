package exe5;

public class Main {
    public static void main(String[] args) {
        Produto p1 = new Produto("Caderno", 25);
        
        Eletronico e1 = new Eletronico("fone de ouvido", 50, 12);

        System.out.println("  Detalhes do Produto 1   ");
        p1.exibirDetalhes();

        System.out.println("\n  Detalhes do Produto 2  ");
        e1.exibirDetalhes();
    }
}