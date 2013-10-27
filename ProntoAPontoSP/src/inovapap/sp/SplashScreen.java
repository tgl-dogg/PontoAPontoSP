package inovapap.sp;

import inovapap.sp.gtfs.Stops;
import inovapap.sp.util.Geral;
import inovapap.sp.util.ILog;
import inovapap.sp.util.Parser;

import java.io.InputStream;
import java.util.ArrayList;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;

public class SplashScreen extends Activity implements Runnable {
	private final String TAG = "SplashScreen ";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		try {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_splash_screen);
			setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

			new LoadStopsTask().execute("");
		} catch (Exception ex) {
			ILog.e(TAG + "onCreate()", ex.getMessage());
		}
	}

	/** Inicia a Activity PontoAPonto, que contém a visualização do mapa. */
	private void startPontoAPontoActivity() {
		Handler handler = new Handler();
		handler.postDelayed(SplashScreen.this, 1);
	}

	@Override
	public void run() {
		Intent intent = new Intent(this, PontoAPontoActivity.class);
		startActivity(intent);
		finish();
	}

	/**
	 * Task assíncrona para carregar dados de um arquivo de texto em background,
	 * evitando processamento pesado na Thread Visual.
	 */
	public class LoadStopsTask extends AsyncTask<String, String, String> {
		ProgressDialog dialog;

		@Override
		protected void onPreExecute() {
			dialog = new ProgressDialog(SplashScreen.this);
			dialog.setMessage(getString(R.string.carregando));
			dialog.setIndeterminate(true);
			dialog.show();
		}

		@Override
		protected String doInBackground(String... arg0) {
			loadStops();
			return null;
		}

		@Override
		protected void onPostExecute(String result) {
			if (dialog.isShowing()) {
				dialog.dismiss();
			}
			
			startPontoAPontoActivity();
		}
	}

	/**
	 * Carrega os valores de pontos de ônibus, metrôs e trens do arquivo
	 * Stops.txt em uma ArrayList global estática.
	 */
	private void loadStops() {
		Geral.stops = new ArrayList<Stops>();
		int counter = 0;

		InputStream is = getResources().openRawResource(R.raw.stops);
		Parser parser = new Parser();
		ArrayList<String> line = parser.generalParseLine(is);

		try {
			is.close();
		} catch (Exception ex) {
			ILog.e(TAG + "loadStops()", ex.getMessage());
		}

		for (String s : line) {
			Stops stop = new Stops(s);
			Geral.stops.add(stop);
			ILog.i("StopCounter", "" + ++counter);
		}

		line.clear();
	}
}
