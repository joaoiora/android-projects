package com.example.joao.prova1listagemcinema.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.joao.prova1listagemcinema.R;
import com.example.joao.prova1listagemcinema.model.Ator;

/**
 * Created by Joao on 12/09/2017.
 */
public class ElencoView extends RelativeLayout {

    /**
     * Componente para representar uma foto do ator.
     */
    private ImageView imagemAtor;

    /**
     * Componente para representar o nome do ator.
     */
    private TextView textNome;

    /**
     * Componente para representar se o ator foi selecionado.
     */
    private CheckBox checkBox;

    /**
     * {@inheritDoc}
     */
    public ElencoView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        LayoutInflater.from(context).inflate(R.layout.list_item_elenco, this, true);
        setupChildren();
    }

    /**
     * {@inheritDoc}
     */
    public ElencoView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    /**
     * {@inheritDoc}
     */
    public ElencoView(Context context) {
        this(context, null);
    }

    /**
     * Realiza o <i>bind</i> das propriedades de um {@code ator} com os respectivos componentes de tela.
     *
     * @param ator Ator a ser apresentado.
     */
    public void setAtor(Ator ator) {
        imagemAtor.setImageResource(ator.getImageId());
        textNome.setText(ator.getNome());
    }

    /**
     * TODO
     */
    public static ElencoView inflate(ViewGroup parent) {
        return (ElencoView) LayoutInflater.from(parent.getContext()).inflate(R.layout.elenco_view, parent, false);
    }

    /**
     * Recupera os componentes da célula de apresentação de um {@link Ator}.
     */
    private void setupChildren() {
        imagemAtor = (ImageView) findViewById(R.id.imagem_ator);
        textNome = (TextView) findViewById(R.id.text_nome);
        checkBox = (CheckBox) findViewById(R.id.check_box);
    }

    /**
     * @return O CheckBox correspondente a uma célula da List View.
     */
    public CheckBox getCheckBox() {
        return checkBox;
    }

}
