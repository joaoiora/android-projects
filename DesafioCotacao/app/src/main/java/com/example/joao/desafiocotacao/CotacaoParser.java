package com.example.joao.desafiocotacao;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Joao on 04/11/2017.
 */

public class CotacaoParser {

	private static final String TAG_NOME = "nome";
	private static final String TAG_VALOR = "valor";
	private static final String TAG_ULTIMA_CONSULTA = "ultima_consulta";
	private static final String TAG_FONTE = "fonte";

	public static Cotacao createFrom(JSONObject json) throws JSONException {
		Cotacao cotacao = new Cotacao();
		cotacao.setNome(json.getString(TAG_NOME));
		cotacao.setValor(json.getDouble(TAG_VALOR));
		final long epoch = json.getLong(TAG_ULTIMA_CONSULTA);
		cotacao.setDataConsulta(DateUtils.toDate(epoch));
		cotacao.setFonte(json.getString(TAG_FONTE));
		return cotacao;
	}

}
