package exe3;

class Eletronico extends Produto implements Tributavel {
 public Eletronico(String descricao, double valorOriginal) {
     super(descricao, valorOriginal);
 }

 @Override
 public double calcularImposto() {
     return this.valorOriginal * 0.15;
 }
}

class Vestuario extends Produto implements Tributavel {
 public Vestuario(String descricao, double valorOriginal) {
     super(descricao, valorOriginal);
 }

 @Override
 public double calcularImposto() {
     return this.valorOriginal * 0.05;
 }
}

class Alimento extends Produto {
 public Alimento(String descricao, double valorOriginal) {
     super(descricao, valorOriginal);
 }
}
