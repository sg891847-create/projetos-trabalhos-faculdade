/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exe3;

/**
 *
 * @author Windows 11
 */
public class MainCasa {
    public static void main(String[] args) {
        Casa casa = new Casa();

        double precoPorTamanho = casa.calcularPreco(80);
        System.out.println("Preço da casa (80m2): R$ " + precoPorTamanho);

        double precoComQuartos = casa.calcularPreco(80, 3);
        System.out.println("Preço da casa (80m3 + 3 quartos): R$ " + precoComQuartos);
    }
}