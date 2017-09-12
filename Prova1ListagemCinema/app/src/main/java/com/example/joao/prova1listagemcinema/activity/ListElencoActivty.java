package com.example.joao.prova1listagemcinema.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;

import com.example.joao.prova1listagemcinema.R;
import com.example.joao.prova1listagemcinema.adapter.ElencoAdapter;
import com.example.joao.prova1listagemcinema.model.Filme;

public class ListElencoActivty extends Activity {

    private Filme filme;

    private ListView listViewElenco;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_elenco);
        setupChildren();
    }

    private void setupChildren() {
        filme = getIntent().getParcelableExtra(MainActivity.KEY_SELECTED_FILME);
        Button shareButton = (Button) findViewById(R.id.share_button);
        shareButton.setOnClickListener(onShareButtonClick);
        listViewElenco = (ListView) findViewById(R.id.lv_elenco);
        listViewElenco.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        listViewElenco.setAdapter(new ElencoAdapter(this, android.R.layout.simple_list_item_multiple_choice, filme.getElenco()));
        listViewElenco.setOnItemClickListener(onItemClickListener);
    }


    private View.OnClickListener onShareButtonClick = new View.OnClickListener() {

        @Override
        public void onClick(View view) {
            SparseBooleanArray checked = listViewElenco.getCheckedItemPositions();
            StringBuilder elenco = new StringBuilder();
            for (int i = 0; i < listViewElenco.getAdapter().getCount(); i++) {
                if (checked.get(i)) {
                    elenco.append(filme.getElenco().get(i));
                }
            }
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            intent.putExtra(Intent.EXTRA_TEXT, elenco.toString());
            startActivity(intent);
        }

    };

    private AdapterView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener() {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            CheckBox checkBox = (CheckBox) view.getTag(R.id.check_box);
            checkBox.setChecked(!checkBox.isChecked());
        }

    };

}
