package com.example.mewallet.model;

import java.io.Serializable;

public class Receita implements Serializable {
    public Receita(String categoria, String valor, String descricao) {
        this.categoria = categoria;
        this.valor = valor;
        this.descricao = descricao;
    }

    public Receita(String categoria, String valor) {
        this.categoria = categoria;
        this.valor = valor;
    }

    public Receita() {
        this.id = id;
    }

    private Long id;
    private String categoria = "categoria";
    private String valor = "valor";
    private String descricao = "descricao";

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }




}
