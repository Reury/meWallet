package com.example.mewallet.model;

public class Pessoa {
    //String nome;
    double saldo;

    public Pessoa(double saldo) {
        this.saldo = saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getSaldo() {
        return saldo;
    }
}
