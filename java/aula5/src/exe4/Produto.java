package exe4;

public class Produto {
    private String nome;
    private int quantidadeEmEstoque;

    public Produto(String nome, int quantidadeInicial) {
        this.nome = nome;
        this.quantidadeEmEstoque = Math.max(0, quantidadeInicial);
    }

    public int getQuantidadeEmEstoque() {
        return quantidadeEmEstoque;
    }

    public void adicionarEstoque(int qtd) {
        if (qtd > 0) {
            this.quantidadeEmEstoque += qtd;
        } else {
            System.out.println("Erro: A quantidade a adicionar deve ser maior que zero.");
        }
    }

    public void removerEstoque(int qtd) {
        if (qtd <= 0) {
            System.out.println("Erro: A quantidade a remover deve ser maior que zero.");
        } else if (this.quantidadeEmEstoque - qtd < 0) {
            System.out.println("Erro: Estoque insuficiente. Operação cancelada.");
        } else {
            this.quantidadeEmEstoque -= qtd;
        }
    }
}
