package exe1;

public class ProdutoDigital extends Produto implements Avaliavel {

    public ProdutoDigital(String nome, double preco) {
        super(nome, preco);
    }

    @Override
    public double calcularFrete() {
        return 0.0;
    }

    @Override
    public void adicionarAvaliacao(int nota) throws NotaInvalidaException {
        if (nota < 1 || nota > 5) {
            throw new NotaInvalidaException("Nota inválida! A nota deve ser entre 1 e 5.");
        }
        System.out.println("Nota " + nota + " adicionada para o produto digital: " + getNome());
    }
}
