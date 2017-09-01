package br.ucb.desafioacademia.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import br.ucb.desafioacademia.R;
import br.ucb.desafioacademia.model.Usuario;

/**
 * Created by João Carlos Iora on 31/08/17.
 */
public class LoginActivity extends Activity {

    /**
     * TODO: extrair para uma classe externa de chaves?
     */
    public static final String KEY_LOGGED_USER = "CONST_LOGGED_USER";

    /**
     *
     */
    private Usuario usuario;

    /**
     *
     */
    private EditText editTextUser;

    /**
     *
     */
    private EditText editTextPass;

    /**
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setupChildren();
        fillViewContent();
    }

    /**
     *
     */
    private void setupChildren() {
        editTextUser = (EditText) findViewById(R.id.edit_text_user);
        editTextPass = (EditText) findViewById(R.id.edit_text_pw);
        usuario = new Usuario("birineu", "uenirib");
    }

    /**
     *
     */
    private void fillViewContent() {
        editTextUser.setText(usuario.getCodigo());
        editTextPass.setText(usuario.getSenha());
    }

    /**
     *
     * @param view
     */
    public void doLogin(View view) {
        if (validLogin()) {
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra(LoginActivity.KEY_LOGGED_USER, usuario);
            startActivity(intent);
        } else {
            Toast.makeText(this, R.string.erro_login, Toast.LENGTH_SHORT).show();
        }
    }

    /**
     *
     * @return
     */
    private boolean validLogin() {
        if (!TextUtils.isEmpty(editTextUser.getText()) && !TextUtils.isEmpty(editTextPass.getText())) {
            String codigo = editTextUser.getText().toString();
            String senha = editTextPass.getText().toString();
            return codigo.equals(usuario.getCodigo()) && senha.equals(usuario.getSenha());
        }
        return false;
    }

}
