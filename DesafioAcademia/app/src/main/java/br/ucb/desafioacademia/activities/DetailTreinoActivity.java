package br.ucb.desafioacademia.activities;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import br.ucb.desafioacademia.R;
import br.ucb.desafioacademia.model.Treino;

/**
 * Created by João Carlos Iora on 01/09/17.
 */
public class DetailTreinoActivity extends Activity {

    /**
     *
     */
    private TextView textDiaSemana;

    /**
     *
     */
    private TextView textMembro;

    /**
     *
     */
    private TextView textNomeTreino;

    /**
     *
     */
    private Treino treino;

    /**
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_treino);
        setupChildren();
        fillViewContent();
    }

    /**
     *
     */
    private void fillViewContent() {
        textDiaSemana.setText(treino.getDia());
        textMembro.setText(treino.getMembro());
        textNomeTreino.setText(treino.getNome());
    }

    /**
     *
     */
    private void setupChildren() {
        textDiaSemana = (TextView) findViewById(R.id.text_dia_semana);
        textMembro = (TextView) findViewById(R.id.text_membro);
        textNomeTreino = (TextView) findViewById(R.id.text_nome_treino);
        treino = (Treino) getIntent().getParcelableExtra(ListTreinoActivity.KEY_SELECTED_TREINO);
    }

}
