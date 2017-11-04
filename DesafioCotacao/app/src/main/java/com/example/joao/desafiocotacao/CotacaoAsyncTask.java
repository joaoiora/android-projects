package com.example.joao.desafiocotacao;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 */
public class CotacaoAsyncTask extends AsyncTask<String, String, String> {

	/**
	 *
	 */
	private Context context;

	/**
	 *
	 */
	private String chave;

	/**
	 *
	 */
	private ProgressDialog dialog;

	/**
	 * @param context
	 */
	public CotacaoAsyncTask(Context context, String chave) {
		this.context = context;
		this.chave = chave;
	}

	/**
	 * Runs on the UI thread before {@link #doInBackground}.
	 *
	 * @see #onPostExecute
	 * @see #doInBackground
	 */
	@Override
	protected void onPreExecute() {
		super.onPreExecute();
		dialog = ProgressDialog.show(context, context.getString(R.string.task_title), context.getString(R.string.task_message));
	}

	/**
	 * Override this method to perform a computation on a background thread. The
	 * specified parameters are the parameters passed to {@link #execute}
	 * by the caller of this task.
	 * <p>
	 * This method can call {@link #publishProgress} to publish updates
	 * on the UI thread.
	 *
	 * @param params The parameters of the task.
	 * @return A result, defined by the subclass of this task.
	 * @see #onPreExecute()
	 * @see #onPostExecute
	 * @see #publishProgress
	 */
	@Override
	protected String doInBackground(String... params) {
		return WebRequest.getContent(params[0]);
	}

	/**
	 * <p>Runs on the UI thread after {@link #doInBackground}. The
	 * specified result is the value returned by {@link #doInBackground}.</p>
	 * <p>
	 * <p>This method won't be invoked if the task was cancelled.</p>
	 *
	 * @param s The result of the operation computed by {@link #doInBackground}.
	 * @see #onPreExecute
	 * @see #doInBackground
	 * @see #onCancelled(Object)
	 */
	@Override
	protected void onPostExecute(String s) {
		super.onPostExecute(s);
		dialog.dismiss();
		try {
			JSONObject json = new JSONObject(s);
			json = json.getJSONObject("valores");
			json = json.getJSONObject(chave);
			Cotacao cotacao = CotacaoParser.createFrom(json);
			if (context instanceof MainActivity) {
				((MainActivity) context).fillViewContent(cotacao);
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

}
