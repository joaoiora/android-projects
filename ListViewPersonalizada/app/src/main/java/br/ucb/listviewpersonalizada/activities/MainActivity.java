package br.ucb.listviewpersonalizada.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import br.ucb.listviewpersonalizada.R;
import br.ucb.listviewpersonalizada.model.Produto;

/**
 * Created by João Carlos Iora on 06/09/2017.
 */
public class MainActivity extends Activity {

    private ListView listViewProdutos;

    private Button shareButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupChildren();
    }

    private void setupChildren() {
        listViewProdutos = (ListView) findViewById(R.id.lv_produto);
        listViewProdutos.setAdapter(new ProdutoAdapter(this, android.R.layout.simple_list_item_1, getProdutos()));
        shareButton = (Button) findViewById(R.id.share_button);
        shareButton.setVisibility(View.INVISIBLE); // deve ficar visível apenas quando um item for selecionado
        CheckBox checkBox = (CheckBox) findViewById(R.id.check_box);
//        checkBox.setOnCheckedChangeListener(); TODO implementar para quando for selecionado, o botão de compartilhar ficar visível
//        listViewProdutos.getCheckedItemIds(); TODO para cada item selecionado, carregar e permitir que seja compartilhável
    }

    private List<Produto> getProdutos() {
        List<Produto> produtos = new ArrayList<>();
        produtos.add(new Produto("a", "aaaa"));
        produtos.add(new Produto("b", "bbbb"));
        produtos.add(new Produto("c", "cccc"));
        produtos.add(new Produto("d", "dddd"));
        produtos.add(new Produto("e", "eeee"));
        produtos.add(new Produto("f", "ffff"));
        produtos.add(new Produto("g", "gggg"));
        produtos.add(new Produto("h", "hhhh"));
        return produtos;
    }
}
