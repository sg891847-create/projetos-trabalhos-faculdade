/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exe4;

/**
 *
 * @author Windows 11
 */
public class MainPagamento {
    public static void main(String[] args) {
        MetodoPagamento cartao = new CartaoCreditoPagamento();
        MetodoPagamento paypal = new PayPalPagamento();
        MetodoPagamento pix = new PIXPagamento();

        cartao.processaPagamento(250.00);
        cartao.mostraDetalhesPagamento();
        System.out.println("-------------------------------------");

        paypal.processaPagamento(120.50);
        paypal.mostraDetalhesPagamento();
        System.out.println("-------------------------------------");

        pix.processaPagamento(85.00);
        pix.mostraDetalhesPagamento();
    }
}
