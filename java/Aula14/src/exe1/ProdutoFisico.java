package exe1;

public class ProdutoFisico extends Produto implements Avaliavel {
    
    public ProdutoFisico(String nome, double preco) {
        super(nome, preco);
    }

    @Override
    public double calcularFrete() {
        return getPreco() * 0.10; // 10% do valor
    }

    @Override
    public void adicionarAvaliacao(int nota) throws NotaInvalidaException {
        if (nota < 1 || nota > 5) {
            throw new NotaInvalidaException("Nota inválida! A nota deve ser entre 1 e 5.");
        }
        System.out.println("Nota " + nota + " adicionada para o produto físico: " + getNome());
    }
}
