package exe2;

public class ContaCorrente extends ContaBancaria implements Tributavel, TransacaoOnline {
 private static final double TAXA_SAQUE = 5.00; 
 public ContaCorrente(String titular) {
     super(titular);
 }

 @Override
 public void sacar(double valor) throws SaldoInsuficienteException {
     double valorTotal = valor + TAXA_SAQUE;
     
     if (valorTotal > getSaldo()) {
         throw new SaldoInsuficienteException("Saldo insuficiente para realizar o saque com a taxa.");
     }
     
     debitar(valorTotal);
     System.out.println("Saque de R$ " + valor + " realizado com sucesso!");
 }

 @Override
 public void calcularImpostos() {
     System.out.println("Calculando impostos da Conta Corrente...");
 }

 @Override
 public void fazerPix(String chavePix, double valor) {
     System.out.println("Enviando PIX de R$ " + valor + " para: " + chavePix);
 }
}