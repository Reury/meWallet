package com.example.mewallet.helper;

import com.example.mewallet.model.Receita;

import java.util.List;

public interface IReceitaDao {

    public boolean salvar(Receita receita);
    public boolean atualizar(Receita receita);
    public boolean deletar(Receita receita);
    public List<Receita> listar();



}
