package com.example.joao.prova1listagemcinema.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.joao.prova1listagemcinema.R;
import com.example.joao.prova1listagemcinema.model.Filme;

/**
 * Created by Joao on 12/09/2017.
 * TODO desacoplar logica de FilmeAdapter quanto ao Inflate.
 *      requer mudanças no layout
 */
public class FilmeView extends LinearLayout {

    /**
     *
     */
    private ImageView gridImage;

    /**
     *
     */
    private TextView gridGenero;

    /**
     *
     */
    private Button buttonDetail;

    /**
     * {@inheritDoc}
     */
    public FilmeView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        LayoutInflater.from(context).inflate(R.layout.activity_main, this, true);
        setupChildren();
    }

    /**
     * {@inheritDoc}
     */
    public FilmeView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    /**
     * {@inheritDoc}
     */
    public FilmeView(Context context) {
        this(context, null);
    }

    /**
     * Realiza o <i>bind</i> das propriedades de um {@code filme} com seus componentes de tela.
     * @param filme Filme a ser apresentado.
     */
    public void setFilme(Filme filme) {
        gridImage.setImageResource(filme.getImageId());
        gridGenero.setText(filme.getGenero());
    }

    /**
     * TODO
     * @param parent
     * @return
     */
    public static FilmeView inflate(ViewGroup parent) {
        return (FilmeView) LayoutInflater.from(parent.getContext()).inflate(R.layout.row_grid, parent, false);
    }

    /**
     *
     */
    private void setupChildren() {
    }

}
