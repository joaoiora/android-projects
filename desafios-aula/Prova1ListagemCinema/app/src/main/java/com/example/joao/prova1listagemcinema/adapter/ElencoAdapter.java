package com.example.joao.prova1listagemcinema.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.example.joao.prova1listagemcinema.R;
import com.example.joao.prova1listagemcinema.model.Ator;
import com.example.joao.prova1listagemcinema.view.ElencoView;

import java.util.List;

/**
 * Created by Joao on 12/09/2017.
 */
public class ElencoAdapter extends ArrayAdapter<Ator> {

    /**
     * {@inheritDoc}
     */
    public ElencoAdapter(Context context, int resource, List<Ator> elenco) {
        super(context, resource, elenco);
    }

    /**
     * {@inheritDoc}
     */
    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        ElencoView elencoView = (ElencoView) convertView;
        if (elencoView == null) {
            elencoView = ElencoView.inflate(parent);
        }
        elencoView.setAtor(getItem(position));
        elencoView.setTag(R.id.check_box, elencoView.getCheckBox());
        return elencoView;
    }
}
