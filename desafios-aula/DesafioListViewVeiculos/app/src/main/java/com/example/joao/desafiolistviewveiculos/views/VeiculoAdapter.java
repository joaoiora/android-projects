package com.example.joao.desafiolistviewveiculos.views;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.example.joao.desafiolistviewveiculos.model.Veiculo;

import java.util.List;

/**
 * Created by Joao on 15/08/2017.
 *
 * https://www.bignerdranch.com/blog/customizing-android-listview-rows-subclassing/
 */
public class VeiculoAdapter extends ArrayAdapter<Veiculo> {

    /**
     *
     * @param context
     * @param veiculos
     */
    public VeiculoAdapter(Context context, List<Veiculo> veiculos) {
        super(context, 0, veiculos);
    }

    /**
     *
     * @param context
     * @param resource
     * @param veiculos
     */
    public VeiculoAdapter(Context context, int resource, List<Veiculo> veiculos) {
        super(context, resource, veiculos);
    }

    /**
     *
     * @param position
     * @param convertView
     * @param parent
     * @return
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        VeiculoView veiculoView = (VeiculoView) convertView;
        if (veiculoView == null) {
            // Não tenho uma view para reutilizar...
            veiculoView = VeiculoView.inflate(parent);
        }
        veiculoView.setVeiculo(getItem(position));
        return veiculoView;
    }

}
