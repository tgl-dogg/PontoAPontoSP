package inovapap.sp;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnMapLongClickListener;
import com.google.android.gms.maps.GoogleMap.OnMarkerClickListener;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import inovapap.sp.gtfs.Route;
import inovapap.sp.gtfs.Stops;
import inovapap.sp.util.Geral;
import inovapap.sp.util.ILog;
import inovapap.sp.util.Parser;
import android.content.pm.ActivityInfo;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TableRow;

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

	private ArrayList<Route> routes;
	private ArrayList<Stops> stops;

	@Override
	protected void onCreate(Bundle b) {
		try {
			super.onCreate(b);
			setContentView(R.layout.interface_layout);
			setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

			initViews();
			initMap();
			loadStops();
			loadRoutes();

		} catch (Exception ex) {
			ILog.e(TAG + "onCreate()", ex.getMessage());
		}
	}

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

		android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
		mapFragment = (SupportMapFragment) fragmentManager
				.findFragmentById(R.id.map_fragment);

		map = mapFragment.getMap();
	}

	private void initMap() {
		map.setMyLocationEnabled(true);

	}

	private void loadStops() {
		stops = new ArrayList<Stops>();
		int counter = 0;

		InputStream is = getResources().openRawResource(R.raw.stops);
		Parser parser = new Parser();
		ArrayList<String> line = parser.generalParseLine(is);

		int size = line.size();
		for (int i = 0; i < size; i++) {
			Stops stop = new Stops(line.get(0));
			stops.add(stop);
			ILog.i("counter", "" + ++counter);
		}
		
		line.clear();
	}

	private void loadRoutes() {
		routes = new ArrayList<Route>();
		int counter = 0;

		InputStream is = getResources().openRawResource(R.raw.routes);
		Parser parser = new Parser();
		ArrayList<String> line = parser.generalParseLine(is);

		int size = line.size();
		for (int i = 0; i < size; i++) {
			Route route = new Route(line.get(0));
			routes.add(route);
			ILog.i("counter", "" + ++counter);
		}

		line.clear();
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		
		// TODO adicionar seleção de casos para as views.
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
}
