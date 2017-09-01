package br.ucb.desafioacademia.activities;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import br.ucb.desafioacademia.R;
import br.ucb.desafioacademia.model.Usuario;
import br.ucb.desafioacademia.utils.StringUtils;

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
        usuario = (Usuario) getIntent().getParcelableExtra(LoginActivity.KEY_LOGGED_USER);
    }

    /**
     *
     */
    private void fillViewContent() {
        textNomeUsuario.setText(usuario.getNome());
        textTelefone.setText(aplicarMascara(usuario.getTelefone()));
        textEmail.setText(usuario.getEmail());
    }

    /**
     *
     * @param telefone
     * @return
     */
    private String aplicarMascara(String telefone) {
        if (StringUtils.isNotEmpty(telefone)) {
            StringBuilder sb = new StringBuilder();
            int len = telefone.length();
            if (len == 10 || len == 11) {
                sb.append("(").append(telefone.substring(0, 2)).append(")");
                sb.append(" ").append(telefone.substring(2, 6)).append("-");
                sb.append(telefone.substring(6));
            } else if (len == 8 || len == 9) {
                sb.append(telefone.substring(0, 4)).append("-").append(telefone.substring(4));
            }
            return sb.toString();
        }
        return "";
    }

}
