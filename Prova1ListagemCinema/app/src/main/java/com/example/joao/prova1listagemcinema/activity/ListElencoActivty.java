package com.example.joao.prova1listagemcinema.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;

import com.example.joao.prova1listagemcinema.R;
import com.example.joao.prova1listagemcinema.adapter.ElencoAdapter;
import com.example.joao.prova1listagemcinema.model.Filme;

/**
 * Created by Joao on 12/09/2017.
 */
public class ListElencoActivty extends Activity {

    /**
     * Filme que está sendo analisado.
     */
    private Filme filme;

    /**
     * Responsável por apresentar os atores do filme em formato de lista.
     */
    private ListView listViewElenco;

    /**
     * {@inheritDoc}
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_elenco);
        setupChildren();
    }

    /**
     * Resgata os componentes de tela que serão necessários para utilização e <i>binding</i>
     * dos dados do elenco do {@link #filme}.
     */
    private void setupChildren() {
        filme = getIntent().getParcelableExtra(MainActivity.KEY_SELECTED_FILME);
        Button shareButton = (Button) findViewById(R.id.share_button);
        shareButton.setOnClickListener(onShareButtonClick);
        listViewElenco = (ListView) findViewById(R.id.lv_elenco);
        listViewElenco.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        listViewElenco.setAdapter(new ElencoAdapter(this, android.R.layout.simple_list_item_multiple_choice, filme.getElenco()));
        listViewElenco.setOnItemClickListener(onItemClickListener);
    }

    /**
     * Listener para o clique do botão 'Compartilhar'.
     * <p>
     * Todos os atores selecionados serão enviados em formato de mensagem.
     */
    private final View.OnClickListener onShareButtonClick = new View.OnClickListener() {

        /**
         * {@inheritDoc}
         */
        @Override
        public void onClick(View view) {
            int count = listViewElenco.getCount();
            StringBuilder elenco = new StringBuilder("=== Atores Selecionados ===\n");
            for (int i = 0; i < count; i++) {
                if (listViewElenco.isItemChecked(i)) {
                    elenco.append("> ").append(listViewElenco.getItemAtPosition(i)).append("\n");
                }
            }
            elenco.append("=========================");
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            intent.putExtra(Intent.EXTRA_TEXT, elenco.toString());
            startActivity(intent);
        }

    };

    /**
     * Listener para o clique de uma célula da listagem. Faz o CheckBox da listagem marcar ou desmarcar.
     */
    private final AdapterView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener() {

        /**
         * {@inheritDoc}
         */
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            CheckBox checkBox = (CheckBox) view.getTag(R.id.check_box);
            checkBox.setChecked(!checkBox.isChecked());
        }

    };

}
