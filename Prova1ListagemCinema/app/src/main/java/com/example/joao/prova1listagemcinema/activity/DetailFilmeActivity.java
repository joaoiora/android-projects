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

/**
 * Created by Joao on 12/09/2017.
 */
public class DetailFilmeActivity extends Activity {

    /**
     * Filme que está sendo detalhado.
     */
    private Filme filme;

    /**
     * Componente responsável por apresentar a capa do filme.
     */
    private ImageView imageView;

    /**
     * Representação do nome do Diretor do filme.
     */
    private TextView textDirecao;

    /**
     * Representação do Gênero do filme.
     */
    private TextView textGenero;

    /**
     * Representação da Nacionalidade do filme.
     */
    private TextView textNacionalidade;

    /**
     * Representação da Sinopse do filme.
     */
    private TextView textSinopse;

    /**
     * {@inheritDoc}
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_filme);
        setupChildren();
        fillViewContent();
    }

    /**
     * Resgata os componentes de tela que serão necessários para utilização e <i>binding</i>
     * dos dados do {@link #filme}.
     */
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

    /**
     * Associa os dados do {@link #filme} com seus respectivos componentes de tela.
     */
    private void fillViewContent() {
        imageView.setImageResource(filme.getImageId());
        textDirecao.setText(filme.getNomeDiretor());
        textGenero.setText(filme.getGenero());
        textNacionalidade.setText(filme.getNacionalidade());
        textSinopse.setText(filme.getSinopse());
    }

    /**
     * Listener de clique para o botão de visualização do Elenco do filme.
     */
    private final View.OnClickListener onElencoClickListener = new View.OnClickListener() {

        /**
         * {@inheritDoc}
         */
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(DetailFilmeActivity.this, ListElencoActivty.class);
            intent.putExtra(MainActivity.KEY_SELECTED_FILME, filme);
            startActivity(intent);
        }

    };

}
