package com.example.mewallet.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.mewallet.model.Receita;

import java.util.ArrayList;
import java.util.List;

public class ReceitaDAO implements  IReceitaDao{

    private SQLiteDatabase escreve;
    private SQLiteDatabase le;

    public ReceitaDAO(Context context) {


        DbHelper db = new DbHelper(context);
        escreve = db.getWritableDatabase();
        le = db.getReadableDatabase();

    }

    @Override
    public boolean salvar(Receita receita) {

        ContentValues cv = new ContentValues();
        cv.put("categoria",receita.getCategoria());
        cv.put("valor",receita.getValor());
        cv.put("descricao",receita.getDescricao());

        try{
            escreve.insert(DbHelper.TABELA_EXTRATO, "n/a",cv);
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

    /*
    metodo para somar os numeros da lista
     */
    public double soma(){
        double somaLista = 0;
        double despesa = 0;
        double despesas = 0;
        double receita = 0;
        double receitas = 0;
        List<Receita> extrato = new ArrayList<>();

        String sql="SELECT * FROM " + DbHelper.TABELA_EXTRATO + " ;";
        Cursor c = le.rawQuery(sql,null);
        while (c.moveToNext()){
            String categoria = c.getString(c.getColumnIndex("categoria"));
            if(categoria.equals("Debito")){
                String valor = c.getString(c.getColumnIndex("valor"));
                despesa = Double.parseDouble(valor) * -1;
                despesas -= despesa;
            }else{
                String valor = c.getString(c.getColumnIndex("valor"));
                receita = Double.parseDouble(valor);
                receitas += receita;

            }
        }
//        vendo os valores no logcat
//        String rec = Double.toString(receitas);
//        Log.e("valor receita",rec);
//        String deb = Double.toString(despesas);
//        Log.e("valor despesas",deb);
        somaLista = receitas - despesas;


        return somaLista;
    }

    @Override
    public List<Receita> listar() {

        List<Receita> extrato = new ArrayList<>();


        String sql="SELECT * FROM " + DbHelper.TABELA_EXTRATO + " ;";
        Cursor c = le.rawQuery(sql, null);

        while(c.moveToNext()){

            Receita receita = new Receita();

            Long id = c.getLong( c.getColumnIndex("id"));
            String categoria = c.getString( c.getColumnIndex("categoria"));
            String valor = c.getString(c.getColumnIndex("valor"));
            String descricao = c.getString(c.getColumnIndex("descricao"));
            receita.setId(id);
            receita.setCategoria(categoria);
            receita.setValor(valor);
            receita.setDescricao(descricao);
            extrato.add(receita);

        }

        return extrato;


    }
}
