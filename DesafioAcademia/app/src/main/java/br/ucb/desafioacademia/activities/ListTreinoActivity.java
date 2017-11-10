package br.ucb.desafioacademia.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import br.ucb.desafioacademia.R;
import br.ucb.desafioacademia.model.DiaSemana;
import br.ucb.desafioacademia.model.Treino;

/**
 * Created by João Carlos Iora on 01/09/17.
 */
public class ListTreinoActivity extends Activity {

    /**
     *
     */
    public static final String KEY_SELECTED_TREINO = "CONST_SELECTED_TREINO";

    /**
     * Fonte: http://bit.ly/2iNWL1d
     */
    private static final String[] NOME_EXERCICIOS = {"Banco Supino Reto", "Voador", "Triceps Testa", "Abdutor", "Adutor", "Press Militar com Barra"};

    /**
     * Fonte: http://bit.ly/2iNWL1d
     */
    private static final String[] NOME_MEMBROS = {"Peito", "Peito", "Tríceps", "Pernas", "Pernas", "Ombros"};

    /**
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_treino);
        ListView listView = (ListView) findViewById(R.id.lv_dias_semana);
        listView.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, getDiasDaSemana()));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            /**
             * Callback method to be invoked when an item in this AdapterView has
             * been clicked.
             * <p>
             * Implementers can call getItemAtPosition(position) if they need
             * to access the data associated with the selected item.
             *
             * @param parent   The AdapterView where the click happened.
             * @param view     The view within the AdapterView that was clicked (this
             *                 will be a view provided by the adapter)
             * @param position The position of the view in the adapter.
             * @param id       The row id of the item that was clicked.
             */
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String diaDaSemana = (String) parent.getItemAtPosition(position);
                Treino treino = new Treino(diaDaSemana, getNome(position), getMembro(position));
                Intent intent = new Intent(ListTreinoActivity.this, DetailTreinoActivity.class);
                intent.putExtra(ListTreinoActivity.KEY_SELECTED_TREINO, treino);
                startActivity(intent);
            }

        });
    }

    /**
     *
     * @param position
     * @return
     */
    private String getMembro(final int position) {
        // bound-check?
        return NOME_MEMBROS[position];
    }

    /**
     *
     * @param position
     * @return
     */
    private String getNome(final int position) {
        // bound-check?
        return NOME_EXERCICIOS[position];
    }

    /**
     *
     * @return
     */
    private List<String> getDiasDaSemana() {
        List<String> diasDaSemana = new ArrayList<>();
        for (DiaSemana dia : DiaSemana.values()) {
            diasDaSemana.add(dia.getDescricao());
        }
        return diasDaSemana;
    }
}
