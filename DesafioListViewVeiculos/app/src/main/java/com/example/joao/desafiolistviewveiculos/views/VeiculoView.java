package com.example.joao.desafiolistviewveiculos.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.joao.desafiolistviewveiculos.R;
import com.example.joao.desafiolistviewveiculos.model.Veiculo;

/**
 * Created by Joao Iora on 15/08/2017.
 *
 * https://www.bignerdranch.com/blog/customizing-android-listview-rows-subclassing/
 */
public class VeiculoView extends RelativeLayout {

    /**
     * Referência para o componente de imagem responsável por apresentar o ícone da marca do veículo.
     */
    private ImageView iconImageView;

    /**
     * Referência para o componente de texto que apresenta o modelo do veículo.
     */
    private TextView modeloTextView;

    /**
     * Referência para o componente de texto que apresenta a cor do veículo.
     */
    private TextView corTextView;

    /**
     * Construtor é eventualmente chamado durante o processo de "inflating" da view. Responsável também
     * por inflar os list view filhos.
     * @param context
     * @param attributes
     * @param defStyle
     */
    public VeiculoView(Context context, AttributeSet attributes, int defStyle) {
        super(context, attributes, defStyle);
        LayoutInflater.from(context).inflate(R.layout.list_item_veiculo, this, true);
        setupChildren();
    }

    /**
     *
     * @param context
     * @param attributes
     */
    public VeiculoView(Context context, AttributeSet attributes) {
        this(context, attributes, 0);
    }

    /**
     *
     * @param context
     */
    public VeiculoView(Context context) {
        this(context, null);
    }

    /**
     * Realiza o binding dos dados de um veículo aos componentes de tela.
     * @param veiculo
     */
    public void setVeiculo(Veiculo veiculo) {
        iconImageView.setImageResource(veiculo.getImageId());
        modeloTextView.setText(veiculo.getModelo());
        corTextView.setText(veiculo.getCor());
    }

    /**
     *
     * @param parent
     * @return
     */
    public static VeiculoView inflate(ViewGroup parent) {
        return (VeiculoView) LayoutInflater.from(parent.getContext()).inflate(R.layout.veiculo_view, parent, false);
    }

    /**
     * Obtém cada um dos componentes de tela, associando aos atributos da classe.
     */
    private void setupChildren() {
        iconImageView = (ImageView) findViewById(R.id.iconVeiculo);
        modeloTextView = (TextView) findViewById(R.id.viewModelo);
        corTextView = (TextView) findViewById(R.id.viewCor);
    }

    /**
     *
     * @return
     */
    public ImageView getIconImageView() {
        return iconImageView;
    }

    /**
     *
     * @return
     */
    public TextView getModeloTextView() {
        return modeloTextView;
    }

    /**
     *
     * @return
     */
    public TextView getCorTextView() {
        return corTextView;
    }

}
