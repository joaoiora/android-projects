package com.example.joao.desafioemprestimo.activities;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import com.example.joao.desafioemprestimo.R;
import com.example.joao.desafioemprestimo.model.Emprestimo;
import com.example.joao.desafioemprestimo.persistence.Database;
import com.example.joao.desafioemprestimo.persistence.EmprestimoDAO;

/**
 * Created by Joao on 21/10/2017.
 */
public class MainActivity extends Activity {

    public static final String CONST_SELECTED_EMPRESTIMO = "SELECTED_EMPRESTIMO";
    private static final String[] COLUNAS = {"nome_objeto"};
    private static final int[] ID_COMPONENTES = {R.id.text_nome_objeto};

    private ListView listViewEmprestimos;
    private SimpleCursorAdapter adapter;
    private Button buttonEmprestar;

    private EmprestimoDAO emprestimoDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        emprestimoDAO = new EmprestimoDAO(this);
        setupChildren();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (adapter != null) {
            Cursor cursor = emprestimoDAO.loadEmprestimos();
            adapter.changeCursor(cursor);
            adapter.notifyDataSetChanged();
        }
    }

    private void setupChildren() {
        listViewEmprestimos = (ListView) findViewById(R.id.listview_emprestimos);
        adapter = new SimpleCursorAdapter(this, R.layout.list_item_emprestimo,
                emprestimoDAO.loadEmprestimos(), COLUNAS, ID_COMPONENTES, 0);
        listViewEmprestimos.setAdapter(adapter);
        listViewEmprestimos.setOnItemClickListener(onItemClickListener);
        buttonEmprestar = (Button) findViewById(R.id.button_emprestar);
        buttonEmprestar.setOnClickListener(onEmprestarClick);
    }

    private AdapterView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener() {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Cursor cursor = emprestimoDAO.loadEmprestimos();
            cursor.moveToPosition(position);
            final String idEmprestimo = cursor.getString(cursor.getColumnIndexOrThrow(Database.ID_COL));
            Emprestimo emprestimo = emprestimoDAO.loadEmprestimo(idEmprestimo);
            Intent intent = new Intent(MainActivity.this, EmprestarActivity.class);
            intent.putExtra(CONST_SELECTED_EMPRESTIMO, emprestimo);
            startActivity(intent);
        }

    };

    private View.OnClickListener onEmprestarClick = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            Emprestimo emprestimo = null;
            Intent intent = new Intent(MainActivity.this, EmprestarActivity.class);
            intent.putExtra(CONST_SELECTED_EMPRESTIMO, emprestimo);
            startActivity(intent);
        }

    };

}
