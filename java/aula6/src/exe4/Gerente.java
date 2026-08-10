package exe4;

class Gerente extends Funcionario {
 public Gerente(String nome, double salarioBase) {
     super(nome, salarioBase);
 }

 @Override
 public double calcularSalario() {
     return salarioBase * 1.20; 
 }
}

class Vendedor extends Funcionario {
 private double comissao;

 public Vendedor(String nome, double salarioBase, double comissao) {
     super(nome, salarioBase);
     this.comissao = comissao;
 }

 @Override
 public double calcularSalario() {
     return salarioBase + comissao;
 }
}