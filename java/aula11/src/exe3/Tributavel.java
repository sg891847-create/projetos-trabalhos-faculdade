package exe3;

interface Tributavel {
 double calcularImposto();
}

abstract class Produto {
 protected String descricao;
 protected double valorOriginal;

 public Produto(String descricao, double valorOriginal) {
     this.descricao = descricao;
     this.valorOriginal = valorOriginal;
 }

 public void aplicarDesconto(double porcentagem) {
     if (porcentagem < 0 || porcentagem > 50) {
         throw new IllegalArgumentException("Desconto inválido para " + descricao + 
             ": deve ser entre 0% e 50%.");
     }
     this.valorOriginal -= (this.valorOriginal * (porcentagem / 100));
 }

 public String getDescricao() { return descricao; }
 public double getValorOriginal() { return valorOriginal; }
}
