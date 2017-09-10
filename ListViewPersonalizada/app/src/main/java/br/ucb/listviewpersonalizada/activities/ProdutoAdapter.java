package br.ucb.listviewpersonalizada.activities;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;

import java.util.List;

import br.ucb.listviewpersonalizada.model.Produto;

/**
 * Created by João Carlos Iora on 06/09/17.
 */
public class ProdutoAdapter extends ArrayAdapter<Produto> {

    public ProdutoAdapter(Context context, List<Produto> produtos) {
        super(context, 0, produtos);
    }

    public ProdutoAdapter(Context context, int resource, List<Produto> produtos) {
        super(context, resource, produtos);
    }

    public ProdutoAdapter(Context context, int resource, int text, List<Produto> produtos) {
        super(context, resource, text, produtos);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ProdutoView produtoView = (ProdutoView) convertView;
        if (produtoView == null) {
            produtoView = ProdutoView.inflate(parent);
        }
        produtoView.setProduto(getItem(position));
        produtoView.setTag(produtoView.getCheckBox());
//        produtoView.setOnClickListener(onClickListener);
        return produtoView;
    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View view) {
            CheckBox checkBox = (CheckBox) view.getTag();
            checkBox.setChecked(!checkBox.isChecked());
        }

    };

}
