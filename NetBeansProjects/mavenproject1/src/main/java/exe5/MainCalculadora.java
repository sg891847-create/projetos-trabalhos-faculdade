/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exe5;

/**
 *
 * @author Windows 11
 */
public class MainCalculadora {
    public static void main(String[] args) {
        ICalculadora calc = new Calculadora();

        System.out.println("Soma (10 + 5): " + calc.somar(10, 5));
        System.out.println("Subtrasao (10 - 5): " + calc.subtrair(10, 5));
        System.out.println("Multiplicasao (10 * 5): " + calc.multiplicar(10, 5));
        System.out.println("Divisao (10 / 5): " + calc.dividir(10, 5));
        System.out.println("Raiz Quadrada de 16 (indice 2): " + calc.raizquadrada(16, 2));
        System.out.println("Potencia (2^3): " + calc.elevarPotencia(2, 3));
        System.out.println("Logaritmo base 10 (100): " + calc.logaritmo10(100));
    }
}