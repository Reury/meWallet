package com.example.mewallet.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DbHelper extends SQLiteOpenHelper {

    public static int VERSION = 1;
    public static String NOME_DB = "DB_EXTRATO";
    public static String TABELA_EXTRATO = "extrato";


    public DbHelper(Context context){
        super(context, NOME_DB, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE IF NOT EXISTS " + TABELA_EXTRATO
                + "( id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "categoria VARCHAR, "
                + "valor VARCHAR, "
                + "descricao VARCHAR " + ")";

        try {
            db.execSQL(sql);
            Log.i("INFO DB", "Sucesso ao criar a tabela");

        }catch (Exception e){
            Log.i("info db", "erro ao criar tabela" + e.getMessage());
        }



    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS "+ TABELA_EXTRATO
                + "(id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "categoria VARCHAR, "
                + "valor VARCHAR, "
                + "descricao VARCHAR " + ")";
        try {
            db.execSQL(sql);
            onCreate(db);
            Log.i("INFO DB", "sucesso ao atualizar o app");
        }catch (Exception e){
            Log.i("INFO DB", "erro ao atualizar o APP" + e.getMessage());
        }

    }
}
