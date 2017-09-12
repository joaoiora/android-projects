package com.example.joao.prova1listagemcinema.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.GridView;

import com.example.joao.prova1listagemcinema.R;
import com.example.joao.prova1listagemcinema.adapter.FilmeAdapter;
import com.example.joao.prova1listagemcinema.model.Ator;
import com.example.joao.prova1listagemcinema.model.Filme;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Joao on 12/09/2017.
 */
public class MainActivity extends Activity {

    /**
     * Chave para representar qual Filme foi selecionado pelo usuário ao pressionar o botão 'Detalhar'.
     */
    public static final String KEY_SELECTED_FILME = "KEY_SELECTED_FILME";

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
     * Carrega todos os componentes visuais filhos da tela e realiza o <i>bind</i> de seus elementos
     * e propriedades.
     */
    private void setupChildren() {
        GridView gridView = (GridView) findViewById(R.id.main_grid);
        gridView.setAdapter(new FilmeAdapter(this, getFilmes()));
    }

    /**
     * É criado um objeto filme e seu respectivo elenco. Não foi feito um tratamento de string correto
     * para a sinopse.
     * O elenco de cada filme é carregado separadamente. Em um ambiente de produção, o elenco seria carregado
     * de acordo com o relacionamento entre o Filme (1) e seus Atores (n).
     *
     * @return Lista de filmes.
     */
    private List<Filme> getFilmes() {
        List<Filme> filmes = new ArrayList<>();
        // Polícia Federal - A Lei É para Todos
        Filme filme = new Filme(R.drawable.pf, "Marcelo Antunez", "Drama", "Brasil", "Durante a realização da Operação Bidone, a Polícia Federal apreende no interior um caminhão carregado de palmito, que trazia escondido 697 kg de cocaína.");
        filme.setElenco(getElencoPF());
        filmes.add(filme);

        // It - A Coisa
        filme = new Filme(R.drawable.it, "Andy Muschietti", "Terror", "EUA", "Um grupo de sete adolescentes de Derry, uma cidade no Maine, formam o auto-intitulado \"Losers Club\" - o clube dos perdedores. A pacata rotina da cidade é abalada quando crianças começam a desaparecer e tudo o que pode ser encontrado delas são partes de seus corpos. Logo, os integrantes do \"Losers Club\" acabam ficando face a face com o responsável pelos crimes: o palhaço Pennywise.");
        filme.setElenco(getElencoIt());
        filmes.add(filme);

        // A Torre Negra
        filme = new Filme(R.drawable.torrenegra, "Nikolaj Arcel", "Fantasia", "EUA", "Um pistoleiro chamado Roland Deschain (Idris Elba) percorre o mundo em busca da famosa Torre Negra, prédio mágico que está prestes a desaparecer. Essa busca envolve uma intensa perseguição ao poderoso Homem de Preto (Matthew McConaughey), passagens entre tempos diferentes, encontros intensos e confusões entre o real e o imaginário.");
        filme.setElenco(getElencoTorreNegra());
        filmes.add(filme);

        // Atômica
        filme = new Filme(R.drawable.atomica, "David Leitch", "Ação", "EUA", "Lorraine Broughton (Charlize Theron), uma agente disfarçada do MI6, é enviada para Berlim durante a Guerra Fria para investigar o assassinato de um oficial e recuperar uma lista perdida de agentes duplos. Ao lado de David Percival (James McAvoy), chefe da localidade, a assassina brutal usará todas as suas habilidades nesse confronto de espiões.");
        filme.setElenco(getElencoAtomica());
        filmes.add(filme);

        // Annabelle 2
        filme = new Filme(R.drawable.annabelle2, "David F. Sandberg", "Terror", "EUA", "Anos após a trágica morte de sua filha, um habilidoso artesão de bonecas e sua esposa decidem, por caridade, acolher em sua casa uma freira e dezenas de meninas desalojadas de um orfanato. Atormentado pelas lembranças traumáticas, o casal ainda precisa lidar com um amendrontador demônio do passado: Annabelle, criação do artesão.");
        filme.setElenco(getElencoAnnabelle());
        filmes.add(filme);

        return filmes;
    }

    /**
     * @return Lista contendo o elenco de atores do filme Annabelle 2.
     */
    private List<Ator> getElencoAnnabelle() {
        List<Ator> elenco = new ArrayList<>();
        elenco.add(new Ator(R.drawable.steph_sigman, "Stephanie Sigman"));
        elenco.add(new Ator(R.drawable.miranda_otto, "Miranda Otto"));
        elenco.add(new Ator(R.drawable.lulu, "Lulu Wilson"));
        return elenco;
    }

    /**
     * @return Lista contendo o elenco de atores do filme Atômica.
     */
    private List<Ator> getElencoAtomica() {
        List<Ator> elenco = new ArrayList<>();
        elenco.add(new Ator(R.drawable.charlize, "Charlize Theron"));
        elenco.add(new Ator(R.drawable.mcavoy, "James McAvoy"));
        elenco.add(new Ator(R.drawable.sofia, "Sofia Boutella"));
        return elenco;
    }

    /**
     * @return Lista contendo o elenco de atores do filme A Torre Negra.
     */
    private List<Ator> getElencoTorreNegra() {
        List<Ator> elenco = new ArrayList<>();
        elenco.add(new Ator(R.drawable.idriselba, "Idris Elba"));
        elenco.add(new Ator(R.drawable.mccounaughey, "Matthew McConaughey"));
        elenco.add(new Ator(R.drawable.tom_taylor, "Tom Taylor"));
        return elenco;
    }

    /**
     * @return Lista contendo o elenco de atores do filme It - A Coisa.
     */
    private List<Ator> getElencoIt() {
        List<Ator> elenco = new ArrayList<>();
        elenco.add(new Ator(R.drawable.skarsgard, "Bill Skarsgard"));
        elenco.add(new Ator(R.drawable.lieberher, "Jaeden Lieberher"));
        elenco.add(new Ator(R.drawable.wolfhard, "Finn Wolfhard"));
        return elenco;
    }

    /**
     * @return Lista contendo o elenco de atores do filme Polícia Federal - A Lei É Para Todos.
     */
    private List<Ator> getElencoPF() {
        List<Ator> elenco = new ArrayList<>();
        elenco.add(new Ator(R.drawable.calloni, "Antonio Calloni"));
        elenco.add(new Ator(R.drawable.flavia_alessandra, "Flávia Alessandra"));
        elenco.add(new Ator(R.drawable.gomlevsky, "Bruce Gomlevsky"));
        return elenco;
    }

}
