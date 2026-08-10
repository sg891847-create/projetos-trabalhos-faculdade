/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.revisao.mavenproject1;

/**
 *
 * @author Windows 11
 */
public class MainContaCorrente {
    public static void main(String[] args) {
        ContaCorrente novaConta = new ContaCorrente();

        novaConta.definirSaldoInicial(1000f);

        System.out.println("Saldo inicial: R$ " + novaConta.saldo);

        novaConta.sacar(500f);

        novaConta.depositar(50f);

        System.out.println("Saldo apos saque (500) e deposito (50): R$ " + novaConta.saldo);

        novaConta.sacar(600f);

        System.out.println("Saldo final: R$ " + novaConta.saldo);
    }
}
