package com.example.joao.desafioemprestimo.persistence;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Joao on 21/10/2017.
 */
public class Database extends SQLiteOpenHelper {

    private static final String NOME_DATABASE = "Emprestimo.db";
    private static final int VERSAO = 3;

    public static final String TABLE_NAME = "EMPRESTIMO";
    public static final String ID_COL = "_id";
    public static final String NOME_OBJETO_COL = "nome_objeto";
    public static final String NOME_INDIV_COL = "nome_individuo";
    public static final String DATA_EMPR_COL = "data_emprestimo";
    public static final String DATA_DEVOL_COL = "data_devolucao";

    public Database(Context context) {
        super(context, NOME_DATABASE, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        StringBuilder sb = new StringBuilder();
        sb.append(" CREATE TABLE " + TABLE_NAME + "(");
        sb.append(ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, ");
        sb.append(NOME_OBJETO_COL + " TEXT NOT NULL, ");
        sb.append(NOME_INDIV_COL + " TEXT NOT NULL, ");
        sb.append(DATA_EMPR_COL + " DATE NOT NULL, ");
        sb.append(DATA_DEVOL_COL + " DATE NOT NULL) ");
        db.execSQL(sb.toString());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        final String sql = "DROP TABLE IF EXISTS " + TABLE_NAME;
        db.execSQL(sql);
    }

}
