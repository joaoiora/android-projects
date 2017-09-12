package br.ucb.listviewpersonalizada.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import br.ucb.listviewpersonalizada.R;
import br.ucb.listviewpersonalizada.adapters.ProdutoAdapter;
import br.ucb.listviewpersonalizada.model.Produto;

/**
 * Created by João Carlos Iora on 06/09/2017
 */
public class MainActivity extends Activity {

    /**
     *
     */
    private ListView listViewProdutos;

    /**
     *
     */
    private Button shareButton;

    /**
     * {@inheritDoc}
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupChildren();
    }

    /**
     * Obtém todos os elementos da tela principal, associa <i>listeners</i> aos componentes
     * e regula visibilidade dos demais componentes.
     */
    private void setupChildren() {
        shareButton = (Button) findViewById(R.id.share_button);
        listViewProdutos = (ListView) findViewById(R.id.listview_produto);
        shareButton.setVisibility(View.INVISIBLE);
        shareButton.setOnClickListener(onShareButtonClick);
        listViewProdutos.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        listViewProdutos.setAdapter(new ProdutoAdapter(this, android.R.layout.simple_list_item_multiple_choice, getProdutos()));
        listViewProdutos.setOnItemClickListener(onItemClickListener);
    }

    /**
     * Listener para clique do botão {@link #shareButton}.
     */
    private final View.OnClickListener onShareButtonClick = new View.OnClickListener() {

        @Override
        public void onClick(View view) {
            int count = listViewProdutos.getCount();
            StringBuilder produtos = new StringBuilder("=== Produtos Selecionados ===\n");
            for (int position = 0; position < count; position++) {
                if (listViewProdutos.isItemChecked(position)) {
                    produtos.append("> ").append(listViewProdutos.getItemAtPosition(position)).append("\n");
                }
            }
            produtos.append("=========================");
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            intent.putExtra(Intent.EXTRA_TEXT, produtos.toString());
            startActivity(intent);
        }

    };

    /**
     * Listener de clique para um item da List View.
     */
    private final AdapterView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener() {

        /**
         * {@inheritDoc}
         */
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            CheckBox checkBox = (CheckBox) view.getTag();
            checkBox.setChecked(!checkBox.isChecked());
            shareButton.setVisibility(View.VISIBLE); // TODO fazer desaparecer quando não tiver itens selecionados
        }

    };

    /**
     * @return Lista contendo vários objetos do tipo {@link Produto} para serem listados.
     */
    private List<Produto> getProdutos() {
        List<Produto> produtos = new ArrayList<>();
        if (produtos.isEmpty()) {
            produtos.add(new Produto("Cerveja", "Bebida"));
            produtos.add(new Produto("Computador", "Informática"));
            produtos.add(new Produto("C Completo e Total", "Livro"));
            produtos.add(new Produto("Uno Mille com Escada", "Carro Esporte"));
            produtos.add(new Produto("McLaren F1", "Carro"));
            produtos.add(new Produto("Honda Biz", "Moto"));
            produtos.add(new Produto("Bateria", "Instrumento Musical"));
            produtos.add(new Produto("Macbook Pro", "Computador"));
        }
        return produtos;
    }
}
