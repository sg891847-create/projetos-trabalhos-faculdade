package exe11;

public class Main {
    public static void main(String[] args) {
        ItemMenu prato = new ItemMenu("Lasanha", 35.00);
        
        Sobremesa doce = new Sobremesa("Pudim", 12.50, true);
        Sobremesa fruta = new Sobremesa("Salada de Frutas", 10.00, false);

        System.out.println("  Cardápio  ");
        prato.exibirItem();
        
        System.out.println();
        doce.exibirItem();
        
        System.out.println();
        fruta.exibirItem();
    }
}