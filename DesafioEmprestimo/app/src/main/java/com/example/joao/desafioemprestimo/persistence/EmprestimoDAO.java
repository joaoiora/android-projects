package com.example.joao.desafioemprestimo.persistence;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.joao.desafioemprestimo.model.Emprestimo;
import com.example.joao.desafioemprestimo.utils.Dates;

/**
 * Created by Joao on 21/10/2017.
 */
public class EmprestimoDAO {

    private Database database;

    public EmprestimoDAO(Context context) {
        database = new Database(context);
    }

    public void save(Emprestimo emprestimo) {
        SQLiteDatabase sqLitedatabase = database.getWritableDatabase();
        sqLitedatabase.insert(Database.TABLE_NAME, null, getEmprestimoContentValues(emprestimo));
        database.close();
    }

    public void update(Emprestimo emprestimo) {
        SQLiteDatabase sqLiteDatabase = database.getWritableDatabase();
        final String whereClause = Database.ID_COL + " = " + emprestimo.getId();
        sqLiteDatabase.update(Database.TABLE_NAME, getEmprestimoContentValues(emprestimo), whereClause, null);
        sqLiteDatabase.close();
    }

    public Cursor loadEmprestimos() {
        SQLiteDatabase sqLiteDatabase = database.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.query(Database.TABLE_NAME, null, null, null, null, null, null);
        if (cursor != null) {
            cursor.moveToNext();
        }
        sqLiteDatabase.close();
        return cursor;
    }

    public Emprestimo loadEmprestimo(final String idEmprestimo) {
        SQLiteDatabase sqLiteDatabase = database.getReadableDatabase();
        final String whereClause = Database.ID_COL + " = " + idEmprestimo;
        Cursor cursor = sqLiteDatabase.query(Database.TABLE_NAME, null, whereClause, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
            Emprestimo emprestimo = cursorToObject(cursor);
            cursor.close();
            return emprestimo;
        }
        return null;
    }

    public void delete(Emprestimo emprestimo) {
        SQLiteDatabase sqLiteDatabase = database.getWritableDatabase();
        final String whereClause = Database.ID_COL + " = " + emprestimo.getId();
        sqLiteDatabase.delete(Database.TABLE_NAME, whereClause, null);
        sqLiteDatabase.close();
    }

    private ContentValues getEmprestimoContentValues(final Emprestimo emprestimo) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(Database.NOME_OBJETO_COL, emprestimo.getNomeObjeto());
        contentValues.put(Database.NOME_INDIV_COL, emprestimo.getNomeIndividuo());
        contentValues.put(Database.DATA_EMPR_COL, emprestimo.getDataEmprestimoString());
        contentValues.put(Database.DATA_DEVOL_COL, emprestimo.getDataDevolucaoString());
        return contentValues;
    }

    private Emprestimo cursorToObject(Cursor cursor) {
        Emprestimo emprestimo = new Emprestimo();
        emprestimo.setId(cursor.getInt(0));
        emprestimo.setNomeObjeto(cursor.getString(1));
        emprestimo.setNomeIndividuo(cursor.getString(2));
        emprestimo.setDataEmprestimo(Dates.parse(cursor.getString(3)));
        emprestimo.setDataDevolucao(Dates.parse(cursor.getString(4)));
        return emprestimo;
    }

}