/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exe4;

/**
 *
 * @author Windows 11
 */
public class CartaoCreditoPagamento extends MetodoPagamento {

    public CartaoCreditoPagamento() {
        super("Cartão de Credito");
    }

    @Override
    public void processaPagamento(double valor) {
        System.out.println("Processando R$ " + valor + " no " + nomeMetodo + "...");
    }

    @Override
    public void mostraDetalhesPagamento() {
        System.out.println("[Detalhes] Método: " + nomeMetodo + " | ID do Pagamento: " + idPagamento);
    }
}