package com.example.joao.desafioemprestimo.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.example.joao.desafioemprestimo.R;
import com.example.joao.desafioemprestimo.model.Emprestimo;
import com.example.joao.desafioemprestimo.persistence.EmprestimoDAO;
import com.example.joao.desafioemprestimo.utils.Dates;
import com.example.joao.desafioemprestimo.utils.Strings;

/**
 * Created by Joao on 21/10/2017.
 */
public class EmprestarActivity extends Activity {

    private EditText nomeIndividuoEdit;
    private EditText nomeObjetoEdit;
    private EditText dataEmprestimoEdit;
    private EditText dataDevolucaoEdit;
    private EmprestimoDAO emprestimoDAO;
    private Emprestimo emprestimo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emprestar);
        emprestimoDAO = new EmprestimoDAO(this);
        emprestimo = getIntent().getParcelableExtra(MainActivity.CONST_SELECTED_EMPRESTIMO);
        setupChildren();
    }

    private void setupChildren() {
        nomeIndividuoEdit = (EditText) findViewById(R.id.edit_nome_individuo);
        nomeObjetoEdit = (EditText) findViewById(R.id.edit_nome_objeto);
        dataEmprestimoEdit = (EditText) findViewById(R.id.edit_data_emprestimo);
        dataDevolucaoEdit = (EditText) findViewById(R.id.edit_data_devolucao);
        LinearLayout topLayout = (LinearLayout) findViewById(R.id.lyt_top);
        Button cobrarButton = (Button) findViewById(R.id.button_cobrar);
        Button devolverButton = (Button) findViewById(R.id.button_devolver);
        Button atualizarButton = (Button) findViewById(R.id.button_atualizar);
        atualizarButton.setOnClickListener(onAtualizarButtonClick);
        if (emprestimo == null) {
            topLayout.setVisibility(View.GONE);
            cobrarButton.setVisibility(View.GONE);
            devolverButton.setVisibility(View.GONE);
            atualizarButton.setText(R.string.emprestar);
        } else {
            cobrarButton.setOnClickListener(onCobrarButtonClick);
            devolverButton.setOnClickListener(onDevolverButtonClick);
            fillViewContent();
        }
    }

    private void fillViewContent() {
        nomeIndividuoEdit.setText(emprestimo.getNomeIndividuo());
        nomeObjetoEdit.setText(emprestimo.getNomeObjeto());
        dataEmprestimoEdit.setText(Dates.format(emprestimo.getDataEmprestimo()));
        dataDevolucaoEdit.setText(Dates.format(emprestimo.getDataDevolucao()));
    }

    private View.OnClickListener onCobrarButtonClick = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_SEND);
            intent.putExtra(Intent.EXTRA_TEXT, emprestimo.getMensagemCobranca());
            intent.setType("text/plain");
            startActivity(intent);
        }

    };

    private View.OnClickListener onDevolverButtonClick = new View.OnClickListener() {

        @Override
        public void onClick(View view) {
            emprestimoDAO.delete(emprestimo);
            finish();
        }

    };

    private View.OnClickListener onAtualizarButtonClick = new View.OnClickListener() {

        @Override
        public void onClick(View view) {
            // TODO: jogar validação para EmprestimoValidator
            // Falar a verdade, ta nem validando...
            String individuo = nomeIndividuoEdit.getText().toString();
            if (Strings.isBlank(individuo)) {
                nomeIndividuoEdit.setError(getResources().getString(R.string.msg_erro_individuo));
            }
            String objeto = nomeObjetoEdit.getText().toString();
            if (Strings.isBlank(objeto)) {
                nomeObjetoEdit.setError(getResources().getString(R.string.msg_erro_objeto));
            }
            String dataEmprestimo = dataEmprestimoEdit.getText().toString();
            if (Strings.isBlank(dataEmprestimo)) {
                dataEmprestimoEdit.setError(getResources().getString(R.string.msg_erro_data_emp));
            }
            String dataDevolucao = dataDevolucaoEdit.getText().toString();
            if (Strings.isBlank(dataDevolucao)) {
                dataDevolucaoEdit.setError(getResources().getString(R.string.msg_erro_data_devol));
            }
            if (emprestimo == null) {
                emprestimo = new Emprestimo();
            }
            emprestimo.setNomeIndividuo(individuo);
            emprestimo.setNomeObjeto(objeto);
            emprestimo.setDataEmprestimo(Dates.parse(dataEmprestimo));
            emprestimo.setDataDevolucao(Dates.parse(dataDevolucao));
            if (emprestimo.getId() != null) {
                emprestimoDAO.update(emprestimo);
            } else {
                emprestimoDAO.save(emprestimo);
            }
            finish();
        }

    };

}
