/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exe3;

/**
 *
 * @author Windows 11
 */
public class Casa {

    public double calcularPreco(int tamanho) {
        return tamanho * 1000.0; 
    }

    public double calcularPreco(int tamanho, int quartos) {
        double precoBase = tamanho * 1000.0;
        double adicionalQuartos = quartos * 15000.0; 
        return precoBase + adicionalQuartos;
    }
}