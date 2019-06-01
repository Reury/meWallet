package com.example.mewallet.model;

import java.io.Serializable;

public class Receita implements Serializable {
    public Receita(String receita, String valor) {
        Receita = receita;
        this.valor = valor;
    }

    public Receita(){

    }

    public String getReceita() {
        return Receita;
    }

    public void setReceita(String receita) {
        Receita = receita;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    private Long id;
    private String Receita;
    private String valor;
    private String descricao;


}
