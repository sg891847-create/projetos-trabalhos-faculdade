package exe1;

public class ContaBancaria {
    private double saldo;
    private double limite;

    // Getters e Setters
    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        if (limite >= 0) {
            this.limite = limite;
        } else {
            System.out.println("Erro: O limite não pode ser negativo.");
        }
    }

    public void sacar(double valor) {
        double disponibilidadeTotal = this.saldo + this.limite;

        if (valor > 0 && valor <= disponibilidadeTotal) {
            this.saldo -= valor;
            System.out.println("Saque de R$ " + valor + " realizado com sucesso.");
        } else {
            System.out.println("Saldo insuficiente! O valor excede o saldo + limite disponível.");
        }
    }
}