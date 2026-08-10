/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.revisao.mavenproject1;

/**
 *
 * @author Windows 11
 */
public class ContaCorrente {
    public float saldo;

    public void definirSaldoInicial(float valor) {
        this.saldo = valor;
    }

    public void depositar(float valor) {
        this.saldo += valor;
    }

    public boolean sacar(float valor) {
        if (valor <= this.saldo) {
            this.saldo -= valor;
            return true;
        } else {
            System.out.println("Saldo insuficiente para o saque de R$ " + valor);
            return false;
        }
    }
}