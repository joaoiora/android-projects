package br.ucb.desafioacademia.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import br.ucb.desafioacademia.R;
import br.ucb.desafioacademia.model.Usuario;

/**
 * Created by João Carlos Iora on 01/09/17.
 */
public class DetailUserActivity extends Activity {

    /**
     *
     */
    private Usuario usuario;

    /**
     *
     */
    private TextView textNomeUsuario;

    /**
     *
     */
    private TextView textTelefone;

    /**
     *
     */
    private TextView textEmail;

    /**
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_user);
        setupChildren();
        fillViewContent();
    }

    /**
     *
     */
    private void setupChildren() {
        textNomeUsuario = (TextView) findViewById(R.id.text_nome_usuario);
        textTelefone = (TextView) findViewById(R.id.text_telefone);
        textEmail = (TextView) findViewById(R.id.text_email);
        Button buttonCompartilhar = (Button) findViewById(R.id.btn_compartilhar);
        buttonCompartilhar.setOnClickListener(new View.OnClickListener() {

            /**
             * Called when a view has been clicked.
             *
             * @param view The view that was clicked.
             */
            @Override
            public void onClick(View view) {
                onClickCompartilhar(view);
            }

        });
        usuario = (Usuario) getIntent().getParcelableExtra(LoginActivity.KEY_LOGGED_USER);
    }

    private void onClickCompartilhar(View view) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_TEXT, usuario.toString());
        intent.setType("text/plain");
        startActivity(intent);
    }

    /**
     *
     */
    private void fillViewContent() {
        textNomeUsuario.setText(usuario.getNome());
        textTelefone.setText(usuario.getTelefoneComMascara());
        textEmail.setText(usuario.getEmail());
    }

}
