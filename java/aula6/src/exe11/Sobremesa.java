package exe11;

public class Sobremesa extends ItemMenu {
    private boolean contemAcucar;

    public Sobremesa(String nome, double preco, boolean contemAcucar) {
        super(nome, preco); 
        this.contemAcucar = contemAcucar;
    }

    @Override
    public void exibirItem() {
        super.exibirItem();
        String aviso = contemAcucar ? "Sim" : "Não";
        System.out.println("Contém açúcar: " + aviso);
    }
}