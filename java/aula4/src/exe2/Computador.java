package exe2;

public class Computador {
    public String marca;
    public String modelo;
    public String tipo;
    public double preco;

    public void exibirInformacoes() {
        System.out.println("Marca: " + marca);
        System.out.println("Modelo: " + modelo);
        System.out.println("Tipo: " + tipo);
        System.out.printf("Preço: R$ %.2f%n", preco);
        System.out.println("----------------------------");
    }

    public static void main(String[] args) {
        System.out.println("Classe Computador pronta para ser instanciada.");
    }
}