package com.example.joao.desafiocotacao;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

/**
 *
 */
public class MainActivity extends Activity {

	// Aplicação deve obter isso de um repositório.
	private static final String SAMPLE_URL = "http://api.promasters.net.br/cotacao/v1/valores?moedas=<MOEDA>&alt=json";
	private static final String REPLACEMENT = "<MOEDA>";
	private final String[] VALID_KEYS = {"USD", "EUR", "ARS", "BTC"};

	private String chave;
	private TextView textNome;
	private TextView textValor;
	private TextView textDataAtualizacao;
	private TextView textFonte;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		setupChildren();
	}

	private void setupChildren() {
		textNome = (TextView) findViewById(R.id.text_nome);
		textValor = (TextView) findViewById(R.id.text_valor);
		textDataAtualizacao = (TextView) findViewById(R.id.text_data_atualizacao);
		textFonte = (TextView) findViewById(R.id.text_fonte);
		changeTextVisibility(View.GONE);
		Button btnDolar = (Button) findViewById(R.id.btn_dolar);
		Button btnEuro = (Button) findViewById(R.id.btn_euro);
		Button btnPeso = (Button) findViewById(R.id.btn_peso);
		Button btnBtc = (Button) findViewById(R.id.btn_bitcoin);
		// Tem jeito melhor?
		btnDolar.setOnClickListener(buttonClickListener);
		btnEuro.setOnClickListener(buttonClickListener);
		btnPeso.setOnClickListener(buttonClickListener);
		btnBtc.setOnClickListener(buttonClickListener);
	}

	public void fillViewContent(Cotacao cotacao) {
		textNome.setText(cotacao.getNome());
		// Pra ficar algo tipo USD 250,00
		// #getLocale(Context) é pra evitar warning
		textValor.setText(String.format(getLocale(this), "%s %.2f", chave, cotacao.getValor()));
		textDataAtualizacao.setText(DateUtils.toString(cotacao.getDataConsulta()));
		textFonte.setText(cotacao.getFonte());
		changeTextVisibility(View.VISIBLE);
	}

	private Locale getLocale(Context context) {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
			return context.getResources().getConfiguration().getLocales().get(0);
		} else {
			//noinspection deprecation
			return context.getResources().getConfiguration().locale;
		}
	}

	private View.OnClickListener buttonClickListener = new View.OnClickListener() {

		/**
		 * Called when a view has been clicked.
		 *
		 * @param view The view that was clicked.
		 */
		@Override
		public void onClick(View view) {
			// Deve ter um jeito melhor de fazer isso...
			switch (view.getId()) {
				case R.id.btn_dolar:
					chave = VALID_KEYS[0];
					break;
				case R.id.btn_euro:
					chave = VALID_KEYS[1];
					break;
				case R.id.btn_peso:
					chave = VALID_KEYS[2];
					break;
				case R.id.btn_bitcoin:
					chave = VALID_KEYS[3];
					break;
				default:
					chave = VALID_KEYS[0];
			}
			String newUrl = SAMPLE_URL.replace(REPLACEMENT, chave);
			new CotacaoAsyncTask(view.getContext(), chave).execute(newUrl);
		}

	};

	private void changeTextVisibility(int visibility) {
		textNome.setVisibility(visibility);
		textValor.setVisibility(visibility);
		textDataAtualizacao.setVisibility(visibility);
		textFonte.setVisibility(visibility);
	}

}
