package com.example.joao.prova1listagemcinema.adapter;

import android.content.Context;
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


    public ElencoAdapter(Context context, List<Ator> elenco) {
        super(context, 0, elenco);
    }

    public ElencoAdapter(Context context, int resource, List<Ator> elenco) {
        super(context, resource, elenco);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ElencoView elencoView = (ElencoView) convertView;
        if (elencoView == null) {
            elencoView = ElencoView.inflate(parent);
        }
        elencoView.setAtor(getItem(position));
        elencoView.setTag(R.id.check_box, elencoView.getCheckBox());
        return elencoView;
    }
}
