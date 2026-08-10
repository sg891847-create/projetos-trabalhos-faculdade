package exe2;


public abstract class ContaBancaria {
 private String titular;
 private double saldo;

 public ContaBancaria(String titular) {
     this.titular = titular;
     this.saldo = 0.0;
 }

 public String getTitular() {
     return titular;
 }

 public double getSaldo() {
     return saldo;
 }

 public void depositar(double valor) {
     if (valor <= 0) {
         throw new IllegalArgumentException("Valor de depósito inválido");
     }
     this.saldo += valor;
 }

 public abstract void sacar(double valor) throws SaldoInsuficienteException;

 protected void debitar(double valor) {
     this.saldo -= valor;
 }
}