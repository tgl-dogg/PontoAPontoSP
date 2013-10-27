package inovapap.sp;

import inovapap.sp.gtfs.Stops;
import inovapap.sp.plots.ReferencedMarker;
import inovapap.sp.util.Geral;
import inovapap.sp.util.ILog;

import java.util.ArrayList;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.location.Location;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TableRow;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class PontoAPontoActivity extends FragmentActivity implements
		OnClickListener, TextWatcher {
	private final String TAG = "PontoAPontoActivity ";

	private LinearLayout llLayout, llTitleLayout, llBottomLayout;
	private RelativeLayout rlMapLayout;
	private TableRow trUpper, trLower;
	private ImageView ivHere, ivWeather, ivSync, ivTourism, ivRoute, ivAlert,
			ivSuggestion;
	private EditText etOrigin, etDestination;

	private SupportMapFragment mapFragment;
	private GoogleMap map;

	private ArrayList<ReferencedMarker> markers = new ArrayList<ReferencedMarker>();

	@Override
	protected void onCreate(Bundle b) {
		try {
			super.onCreate(b);

			// requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
			setContentView(R.layout.interface_layout);

			setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
			// getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE,
			// R.layout.custom_title);

			initViews();
			initMap();
		} catch (Exception ex) {
			ILog.e(TAG + "onCreate()", ex.getMessage());
		}
	}

	@Override
	protected void onStart() {
		try {
			super.onStart();

			if (!Geral.isNetworkAvailable(this)) {
				Geral.showOkNotification(this,
						android.R.drawable.alert_dark_frame, "",
						getString(R.string.sem_conexao), null).show();
			}
		} catch (Exception ex) {
			ILog.e(TAG + "onStart()", ex.getMessage());
		}
	}

	/**
	 * Inicializa as views colocando atribuindo suas referências do xml por Id e
	 * atribuindo os respectivos listeners.
	 */
	private void initViews() {
		llLayout = (LinearLayout) findViewById(R.id.layout);
		llTitleLayout = (LinearLayout) findViewById(R.id.title_linear_layout);
		llBottomLayout = (LinearLayout) findViewById(R.id.bottom_linear_layout);

		rlMapLayout = (RelativeLayout) findViewById(R.id.map_relative_layout);

		trUpper = (TableRow) findViewById(R.id.title_upper_table_row);
		trLower = (TableRow) findViewById(R.id.title_lower_table_row);

		ivHere = (ImageView) findViewById(R.id.here_image_view);
		ivHere.setOnClickListener(this);
		ivWeather = (ImageView) findViewById(R.id.weather_image_view);
		ivWeather.setOnClickListener(this);
		ivSync = (ImageView) findViewById(R.id.sync_image_view);
		ivSync.setOnClickListener(this);
		ivTourism = (ImageView) findViewById(R.id.tourism_image_view);
		ivTourism.setOnClickListener(this);
		ivRoute = (ImageView) findViewById(R.id.route_image_view);
		ivRoute.setOnClickListener(this);
		ivAlert = (ImageView) findViewById(R.id.alert_image_view);
		ivAlert.setOnClickListener(this);
		ivSuggestion = (ImageView) findViewById(R.id.suggestion_image_view);
		ivSuggestion.setOnClickListener(this);

		etOrigin = (EditText) findViewById(R.id.origin_edit_text);
		etOrigin.addTextChangedListener(this);
		etDestination = (EditText) findViewById(R.id.destination_edit_text);
	}

	/**
	 * Inicializa o mapa através de uma biblioteca de compatibilidade para
	 * atender uma gama maior de dispositivos.
	 */
	private void initMap() {
		android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
		mapFragment = (SupportMapFragment) fragmentManager
				.findFragmentById(R.id.map_fragment);

		map = mapFragment.getMap();
		map.setMyLocationEnabled(true);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {

		case R.id.route_image_view:
			startActivity(new Intent(this, ItinerarioDemoActivity.class));
			break;

		case R.id.alert_image_view:
			startActivity(new Intent(this, AlertaDemoActivity.class));
			break;

		case R.id.tourism_image_view:
			plotNearbyStops();
			break;

		case R.id.suggestion_image_view:
			startActivity(new Intent(this, SugestaoDemoActivity.class));
			break;
		}
	}

	@Override
	public void afterTextChanged(Editable arg0) {
		if (etOrigin.getText().toString().equals("")) {
			etDestination.setVisibility(View.GONE);
		} else {
			etDestination.setVisibility(View.VISIBLE);
		}
	}

	@Override
	public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
			int arg3) {
	}

	@Override
	public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
	}

	/**
	 * Procura os pontos de ônibus, metrô e trem mais próximos da localização do
	 * usuário e os plota na tela com ícone em destaque e informações sobre o
	 * mesmo.
	 */
	private void plotNearbyStops() {
		ArrayList<Integer> i = new ArrayList<Integer>();
		double lan1, lon1;

		Location location = map.getMyLocation();
		if (location != null) {
			lan1 = map.getMyLocation().getLatitude();
			lon1 = map.getMyLocation().getLongitude();
		} else {
			Geral.showOkNotification(this, android.R.drawable.alert_dark_frame,
					"", getString(R.string.sem_conexao), null).show();
			return;
		}

		for (Stops stop : Geral.stops) {
			if (isNearby(lan1, lon1, stop.getStopLat(), stop.getStopLon())) {
				i.add(Geral.stops.indexOf(stop));
				ILog.v(TAG + "plotNearbyStops", "Found:" + i.get(i.size() - 1));
			}
		}

		for (int x : i) {
			Stops stop = Geral.stops.get(x);
			MarkerOptions mkop = new MarkerOptions();
			LatLng latlgn = new LatLng(stop.getStopLat(), stop.getStopLon());

			// TODO ícone para plots
			mkop.icon(BitmapDescriptorFactory
					.fromResource(android.R.drawable.star_big_on));
			mkop.title(stop.getStopName());
			mkop.snippet(stop.getStopDesc());
			mkop.position(latlgn);

			ReferencedMarker mk = new ReferencedMarker();
			mk.add(map.addMarker(mkop), stop.getStopId());
			markers.add(mk);
			ILog.v(TAG + "plotNearbyStops", "Ploting:" + stop.getStopName());
		}
	}

	/**
	 * Verifica a distância entre dois pares de coordenadas latitude e longitude
	 * 
	 * @param lan1
	 *            Latitude do ponto 1
	 * @param lon1
	 *            Longitude do ponto 1
	 * @param lan2
	 *            Latitude do ponto 2
	 * @param lon2
	 *            Longitude do ponto 2
	 *            <p>
	 * 
	 * @return <b>True</b>, caso a distância entre as localizações for pequena,<br>
	 *         <b>False</b> caso contrário.
	 * */
	private boolean isNearby(double lan1, double lon1, double lan2, double lon2) {
		double dif1 = lan1 - lan2;
		double dif2 = lon1 - lon2;

		if (dif1 < 0) {
			dif1 *= -1;
		}

		if (dif2 < 0) {
			dif2 *= -1;
		}

		return (dif1 <= 0.005 && dif2 <= 0.005);
	}
}
