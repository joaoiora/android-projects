package com.example.joao.prova1listagemcinema.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.joao.prova1listagemcinema.R;
import com.example.joao.prova1listagemcinema.model.Filme;

public class DetailFilmeActivity extends Activity {

    private Filme filme;

    private ImageView imageView;

    private TextView textDirecao;

    private TextView textGenero;

    private TextView textNacionalidade;

    private TextView textSinopse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_filme);
        setupChildren();
        fillViewContent();
    }

    private void setupChildren() {
        filme = getIntent().getParcelableExtra(MainActivity.KEY_SELECTED_FILME);
        imageView = (ImageView) findViewById(R.id.imagem_filme);
        textDirecao = (TextView) findViewById(R.id.text_direcao);
        textGenero = (TextView) findViewById(R.id.text_genero);
        textNacionalidade = (TextView) findViewById(R.id.text_nacionalidade);
        textSinopse = (TextView) findViewById(R.id.text_sinopse);
        Button buttonDetailElenco = (Button) findViewById(R.id.button_detail_elenco);
        buttonDetailElenco.setOnClickListener(onElencoClickListener);
    }

    private void fillViewContent() {
        imageView.setImageResource(filme.getImageId());
        textDirecao.setText(filme.getNomeDiretor());
        textGenero.setText(filme.getGenero());
        textNacionalidade.setText(filme.getNacionalidade());
        textSinopse.setText(filme.getSinopse());
    }

    private View.OnClickListener onElencoClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(DetailFilmeActivity.this, ListElencoActivty.class);
            intent.putExtra(MainActivity.KEY_SELECTED_FILME, filme);
            startActivity(intent);
        }

    };

}
