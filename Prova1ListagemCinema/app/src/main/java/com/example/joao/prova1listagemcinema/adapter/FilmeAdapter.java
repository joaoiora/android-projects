package com.example.joao.prova1listagemcinema.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.joao.prova1listagemcinema.R;
import com.example.joao.prova1listagemcinema.activity.DetailFilmeActivity;
import com.example.joao.prova1listagemcinema.activity.MainActivity;
import com.example.joao.prova1listagemcinema.model.Filme;

import java.util.List;

/**
 * Created by Joao on 12/09/2017.
 */
public class FilmeAdapter extends ArrayAdapter<Filme> {

    /**
     * Contexto que está utilizando este Adapter.
     */
    private final Context context;

    /**
     * {@inheritDoc}
     */
    public FilmeAdapter(Context context, List<Filme> filmes) {
        super(context, 0, filmes);
        this.context = context;
    }

    /**
     * {@inheritDoc}
     */
    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        // TODO mover lógica abaixo para a classe FilmeView.
        View row;
        if (convertView == null) {
            row = LayoutInflater.from(getContext()).inflate(R.layout.row_grid, parent, false);
        } else {
            row = convertView;
        }
        final Filme filme = getItem(position);
        ImageView gridImage = (ImageView) row.findViewById(R.id.grid_image);
        TextView gridGenero = (TextView) row.findViewById(R.id.grid_txt_genero);
        Button buttonDetail = (Button) row.findViewById(R.id.detail_button);
        buttonDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailFilmeActivity.class);
                intent.putExtra(MainActivity.KEY_SELECTED_FILME, filme);
                context.startActivity(intent);
            }
        });
        if (filme != null) {
            gridImage.setImageResource(filme.getImageId());
            gridGenero.setText(filme.getGenero());
        }
        return row;
    }

}
