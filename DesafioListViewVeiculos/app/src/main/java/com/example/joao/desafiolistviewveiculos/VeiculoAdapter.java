package com.example.joao.desafiolistviewveiculos;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.example.joao.desafiolistviewveiculos.model.Veiculo;

import java.util.List;

/**
 * Created by Joao on 15/08/2017.
 */

public class VeiculoAdapter extends ArrayAdapter<Veiculo> {

    public VeiculoAdapter(Context context, List<Veiculo> veiculos) {
        super(context, 0, veiculos);
    }

    public VeiculoAdapter(Context context, int resource, List<Veiculo> veiculos) {
        super(context, resource, veiculos);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        VeiculoView veiculoView = (VeiculoView) convertView;
        if (veiculoView == null) {
            veiculoView = VeiculoView.inflate(parent);
        }
        veiculoView.setVeiculo(getItem(position));
        return veiculoView;
    }

}
