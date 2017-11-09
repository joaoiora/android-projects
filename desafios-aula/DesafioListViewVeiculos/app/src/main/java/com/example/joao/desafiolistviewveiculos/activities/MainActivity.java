package com.example.joao.desafiolistviewveiculos.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.joao.desafiolistviewveiculos.R;
import com.example.joao.desafiolistviewveiculos.views.VeiculoAdapter;
import com.example.joao.desafiolistviewveiculos.model.Veiculo;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    /**
     * Chave utilizada para identificar qual objeto é adicionado a intent, e também
     * para facilitar sua obtenção
     */
    public static final String KEY_SELECTED_VEICULO = "KEY_SELECTED_VEICULO";

    /**
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = (ListView) findViewById(R.id.listViewVeiculos);
        listView.setAdapter(new VeiculoAdapter(this, android.R.layout.simple_list_item_1, getVeiculos()));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Veiculo veiculo = (Veiculo) parent.getItemAtPosition(position);
                Intent intent = new Intent(MainActivity.this, DetailVeiculoActivity.class);
                intent.putExtra(KEY_SELECTED_VEICULO, veiculo);
                startActivity(intent);
            }

        });
    }

    /**
     * @return
     */
    private static List<Veiculo> getVeiculos() {
        List<Veiculo> veiculos = new ArrayList<>();
        // fonte dos icones: https://www.iconsdb.com
        veiculos.add(new Veiculo("Volkswagen Fusca", "Amarelo", 1994, R.drawable.vw));
        veiculos.add(new Veiculo("BMW 325i", "Rosa Choque", 2015,  R.drawable.bmw));
        veiculos.add(new Veiculo("Volkswagen Polo", "Preto", 2008, R.drawable.vw));
        veiculos.add(new Veiculo("Mercedes C180", "Amarelo", 2010, R.drawable.mercedes));
        veiculos.add(new Veiculo("Ford Mustang", "Vermelho", 2010, R.drawable.ford));
        veiculos.add(new Veiculo("BMW 550i", "Midnight Black", 2014,  R.drawable.bmw));
        veiculos.add(new Veiculo("Mercedes E63", "Azul Bebê", 2013, R.drawable.mercedes));
        veiculos.add(new Veiculo("Ford Ecosport", "Verde", 2012, R.drawable.ford));
        return veiculos;
    }

}
