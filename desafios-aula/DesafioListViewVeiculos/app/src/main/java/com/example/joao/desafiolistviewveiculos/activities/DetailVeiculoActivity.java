package com.example.joao.desafiolistviewveiculos.activities;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.joao.desafiolistviewveiculos.R;
import com.example.joao.desafiolistviewveiculos.model.Veiculo;

import java.text.DecimalFormat;
import java.util.Locale;

public class DetailVeiculoActivity extends Activity {

    private static final String MASCARA_DINHEIRO = "###,##0.00";

    private ImageView imageIcon;
    private TextView textModelo;
    private TextView textCor;
    private TextView textAno;
    private TextView textQuilometragem;
    private TextView textValor;
    private Veiculo selectedVeiculo;

    /**
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_veiculo);
        setupChildren();
        fillView();
    }

    /**
     *
     */
    private void setupChildren() {
        imageIcon = (ImageView) findViewById(R.id.iconeVeiculo);
        textModelo = (TextView) findViewById(R.id.textModelo);
        textCor = (TextView) findViewById(R.id.textCor);
        textAno = (TextView) findViewById(R.id.textAno);
        textQuilometragem = (TextView) findViewById(R.id.textQuilometragem);
        textValor = (TextView) findViewById(R.id.textValor);
        selectedVeiculo = (Veiculo) getIntent().getParcelableExtra(MainActivity.KEY_SELECTED_VEICULO);
    }

    /**
     *
     */
    private void fillView() {
        imageIcon.setImageResource(selectedVeiculo.getImageId());
        textModelo.setText(selectedVeiculo.getModelo());
        textCor.setText(selectedVeiculo.getCor());
        textAno.setText(String.valueOf(selectedVeiculo.getAno().intValue()));
        textQuilometragem.setText(doubleToString(selectedVeiculo.getQuilometragem(), MASCARA_DINHEIRO));
        textValor.setText(doubleToString(selectedVeiculo.getValor(), MASCARA_DINHEIRO));
    }

    /**
     * @param value
     * @param pattern
     * @return
     */
    private String doubleToString(Double value, String pattern) {
        DecimalFormat df = (DecimalFormat) DecimalFormat.getCurrencyInstance(getLocale());
        df.applyPattern(pattern);
        return df.format(value);
    }

    /**
     * Android get current Locale, not default: https://stackoverflow.com/a/39639103
     *
     * @return Locale atual do device.
     */
    @TargetApi(Build.VERSION_CODES.N)
    private Locale getLocale() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            return getResources().getConfiguration().getLocales().get(0);
        } else {
            //noinspection deprecation
            return getResources().getConfiguration().locale;
        }
    }

    public void compartilhar(View view) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, selectedVeiculo.toString());
        startActivity(intent);
    }

    public void abrirMapa(View view) {
//        Uri location = Uri.parse
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setPackage("com.google.android.apps.maps");
        startActivity(intent);
    }

}
