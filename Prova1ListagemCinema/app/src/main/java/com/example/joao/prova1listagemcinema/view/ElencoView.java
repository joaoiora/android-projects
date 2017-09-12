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

    private ImageView imagemAtor;

    private TextView textNome;

    private CheckBox checkBox;

    public ElencoView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        LayoutInflater.from(context).inflate(R.layout.list_item_elenco, this, true);
        setupChildren();
    }

    public ElencoView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ElencoView(Context context) {
        this(context, null);
    }

    public void setAtor(Ator ator) {
        imagemAtor.setImageResource(ator.getImageId());
        textNome.setText(ator.getNome());
    }

    public static ElencoView inflate(ViewGroup parent) {
        return (ElencoView) LayoutInflater.from(parent.getContext()).inflate(R.layout.elenco_view, parent, false);
    }

    private void setupChildren() {
        imagemAtor = (ImageView) findViewById(R.id.imagem_ator);
        textNome = (TextView) findViewById(R.id.text_nome);
        checkBox = (CheckBox) findViewById(R.id.check_box);
    }

    public TextView getTextNome() {
        return textNome;
    }

    public CheckBox getCheckBox() {
        return checkBox;
    }

}
