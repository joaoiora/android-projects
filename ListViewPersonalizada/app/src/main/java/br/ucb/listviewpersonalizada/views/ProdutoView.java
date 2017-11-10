package br.ucb.listviewpersonalizada.views;

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
 *
 * @see <a href="https://www.bignerdranch.com/blog/customizing-android-listview-rows-subclassing/">Customizing Android ListView Rows with Subclassing</a>
 */
public class ProdutoView extends RelativeLayout {

    /**
     *
     */
    private TextView textNome;

    /**
     *
     */
    private TextView textTipo;

    /**
     *
     */
    private CheckBox checkBox;

    /**
     * {@inheritDoc}
     */
    public ProdutoView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        LayoutInflater.from(context).inflate(R.layout.list_item_produto, this, true);
        setupChildren();
    }

    /**
     * {@inheritDoc}
     */
    public ProdutoView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    /**
     * {@inheritDoc}
     */
    public ProdutoView(Context context) {
        this(context, null);
    }

    /**
     * Atualiza as informações dos componentes de tela com determinado {@code produto}.
     *
     * @param produto Produto a ser apresentado.
     */
    public void setProduto(Produto produto) {
        textNome.setText(produto.getNome());
        textTipo.setText(produto.getTipo());
    }

    /**
     * {@inheritDoc}
     * <p>
     * TODO explicar o que o inflate faz e porque é necessário
     */
    public static ProdutoView inflate(ViewGroup parent) {
        return (ProdutoView) LayoutInflater.from(parent.getContext()).inflate(R.layout.produto_view, parent, false);
    }

    /**
     * Busca a referência para cada componente visual da tela.
     */
    private void setupChildren() {
        textNome = (TextView) findViewById(R.id.text_nome);
        textTipo = (TextView) findViewById(R.id.text_tipo);
        checkBox = (CheckBox) findViewById(R.id.check_box);
    }

    /**
     * @return A instância do {@link CheckBox} associado a uma linha do List View.
     */
    public CheckBox getCheckBox() {
        return checkBox;
    }

}
