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
 * Created by João Carlos Iora on 31/08/17.
 */
public class MainActivity extends Activity {

    /**
     *
     */
    private Usuario usuario;

    /**
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupChildren();
    }

    /**
     *
     */
    private void setupChildren() {
        usuario = getIntent().getParcelableExtra(LoginActivity.KEY_LOGGED_USER);
        Button btnUserInfo = (Button) findViewById(R.id.btn_user_info);
        Button btnTraining = (Button) findViewById(R.id.btn_training);
        btnUserInfo.setOnClickListener(new View.OnClickListener() {

            /**
             * Called when a view has been clicked.
             *
             * @param view The view that was clicked.
             */
            @Override
            public void onClick(View view) {
                onClickPersonalInfo(view);
            }

        });
        btnTraining.setOnClickListener(new View.OnClickListener() {

            /**
             * Called when a view has been clicked.
             *
             * @param view The view that was clicked.
             */
            @Override
            public void onClick(View view) {
                onClickTraining(view);
            }

        });
        TextView txtUserCode = (TextView) findViewById(R.id.txt_user_code);
        txtUserCode.setText(usuario.getCodigo());
    }

    /**
     * @param view
     */
    private void onClickPersonalInfo(View view) {
        Intent intent = new Intent(this, DetailUserActivity.class);
        intent.putExtra(LoginActivity.KEY_LOGGED_USER, usuario);
        startActivity(intent);
    }

    /**
     * @param view
     */
    private void onClickTraining(View view) {
        startActivity(new Intent(this, ListTreinoActivity.class));
    }

}
