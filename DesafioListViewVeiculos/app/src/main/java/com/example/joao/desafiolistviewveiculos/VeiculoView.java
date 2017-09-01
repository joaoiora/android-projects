package com.example.joao.desafiolistviewveiculos;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.joao.desafiolistviewveiculos.model.Veiculo;

/**
 * Created by Joao on 15/08/2017.
 */
public class VeiculoView extends RelativeLayout {

    private ImageView iconImageView;
    private TextView modeloTextView;
    private TextView corTextView;

    public VeiculoView(Context context, AttributeSet attributes, int defStyle) {
        super(context, attributes, defStyle);
        LayoutInflater.from(context).inflate(R.layout.list_item_veiculo, this, true);
        setupChildren();
    }

    public VeiculoView(Context context, AttributeSet attributes) {
        this(context, attributes, 0);
    }

    public VeiculoView(Context context) {
        this(context, null);
    }

    public void setVeiculo(Veiculo veiculo) {
        iconImageView.setImageResource(veiculo.getImageId());
        modeloTextView.setText(veiculo.getModelo());
        corTextView.setText(veiculo.getCor());
    }

    public static VeiculoView inflate(ViewGroup parent) {
        return (VeiculoView) LayoutInflater.from(parent.getContext()).inflate(R.layout.veiculo_view, parent, false);
    }

    private void setupChildren() {
        iconImageView = (ImageView) findViewById(R.id.iconVeiculo);
        modeloTextView = (TextView) findViewById(R.id.labelModelo);
        corTextView = (TextView) findViewById(R.id.labelCor);
    }

    public ImageView getIconImageView() {
        return iconImageView;
    }

    public TextView getModeloTextView() {
        return modeloTextView;
    }

    public TextView getCorTextView() {
        return corTextView;
    }
}
