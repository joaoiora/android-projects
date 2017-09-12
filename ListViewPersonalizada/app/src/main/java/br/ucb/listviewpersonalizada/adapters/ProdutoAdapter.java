package br.ucb.listviewpersonalizada.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.List;

import br.ucb.listviewpersonalizada.views.ProdutoView;
import br.ucb.listviewpersonalizada.model.Produto;

/**
 * Created by João Carlos Iora on 06/09/17
 */
public class ProdutoAdapter extends ArrayAdapter<Produto> {

    /**
     * {@inheritDoc}
     */
    public ProdutoAdapter(Context context, int resource, List<Produto> produtos) {
        super(context, resource, produtos);
    }

    /**
     * {@inheritDoc}
     * <p>
     * TODO: descrever com próprias palavras o que o método está fazendo
     */
    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        ProdutoView produtoView = (ProdutoView) convertView;
        if (produtoView == null) {
            produtoView = ProdutoView.inflate(parent);
        }
        produtoView.setProduto(getItem(position));
        produtoView.setTag(produtoView.getCheckBox());
        return produtoView;
    }

}
