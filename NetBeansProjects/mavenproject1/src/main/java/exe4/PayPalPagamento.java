/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exe4;

/**
 *
 * @author Windows 11
 */
public class PayPalPagamento extends MetodoPagamento {

    public PayPalPagamento() {
        super("PayPal");
    }

    @Override
    public void processaPagamento(double valor) {
        System.out.println("Processando R$ " + valor + " via " + nomeMetodo + "...");
    }

    @Override
    public void mostraDetalhesPagamento() {
        System.out.println("[Detalhes] Metodo: " + nomeMetodo + " | ID do Pagamento: " + idPagamento);
    }
}
