package com.example.mewallet.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.mewallet.model.Receita;

import java.util.List;

public class TarefaDAO implements  IReceitaDao{

    private SQLiteDatabase escreve;
    private SQLiteDatabase le;

    public TarefaDAO(Context context) {


        DbHelper db = new DbHelper(context);
        escreve = db .getWritableDatabase();
        le = db.getReadableDatabase();

    }

    @Override
    public boolean salvar(Receita receita) {

        ContentValues cv = new ContentValues();
        cv.put("nome",receita.getValor());

        try{
            escreve.insert(DbHelper.TABELA_EXTRATO, null,cv);
            Log.e("INFO", "receita salva com sucesso");
        }catch (Exception e){
            Log.e("INFO","erro ao adicionar receita " + e.getMessage());
            return  false;
        }


        return true;
    }

    @Override
    public boolean atualizar(Receita receita) {
        return false;
    }

    @Override
    public boolean deletar(Receita receita) {
        return false;
    }

    @Override
    public List<Receita> listar() {
        return null;
    }
}
