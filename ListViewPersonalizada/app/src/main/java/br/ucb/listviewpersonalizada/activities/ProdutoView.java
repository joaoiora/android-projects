package br.ucb.listviewpersonalizada.activities;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;

import br.ucb.listviewpersonalizada.R;
import br.ucb.listviewpersonalizada.model.Produto;

/**
 * Created by João Carlos Iora on 06/09/17.
 * <p>
 * https://www.bignerdranch.com/blog/customizing-android-listview-rows-subclassing/
 */
public class ProdutoView extends RelativeLayout {

    private TextView textNome;

    private TextView textTipo;

    private CheckBox checkBox;

    public ProdutoView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        LayoutInflater.from(context).inflate(R.layout.list_item_produto, this, true);
        setupChildren();
    }

    public ProdutoView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ProdutoView(Context context) {
        this(context, null);
    }

    public void setProduto(Produto produto) {
        textNome.setText(produto.getNome());
        textTipo.setText(produto.getTipo());
    }

    public static ProdutoView inflate(ViewGroup parent) {
        return (ProdutoView) LayoutInflater.from(parent.getContext()).inflate(R.layout.produto_view, parent, false);
    }

    private void setupChildren() {
        textNome = (TextView) findViewById(R.id.text_nome);
        textTipo = (TextView) findViewById(R.id.text_tipo);
        checkBox = (CheckBox) findViewById(R.id.check_box);
    }

    public TextView getTextNome() {
        return textNome;
    }

    public TextView getTextTipo() {
        return textTipo;
    }

    public CheckBox getCheckBox() {
        return checkBox;
    }

}
