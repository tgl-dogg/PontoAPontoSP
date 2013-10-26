package inovapap.sp;

import java.io.InputStream;
import java.util.ArrayList;

import inovapap.sp.gtfs.Route;
import inovapap.sp.gtfs.Shapes;
import inovapap.sp.gtfs.StopTimes;
import inovapap.sp.gtfs.Stops;
import inovapap.sp.gtfs.Trips;
import inovapap.sp.util.ILog;
import inovapap.sp.util.Parser;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;

public class SplashScreen extends Activity implements Runnable {
	private final String TAG = "SplashScreen ";

	private ArrayList<Route> routes;
	private ArrayList<Stops> stops;
	private ArrayList<StopTimes> stopTimes;
	private ArrayList<Trips> trips;
	private ArrayList<Shapes> shapes;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		try {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_splash_screen);
			setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

			Handler handler = new Handler();
			handler.postDelayed(this, 2000);
		} catch (Exception ex) {
			ILog.e(TAG + "onCreate()", ex.getMessage());
		}
	}

	@Override
	public void run() {
		new LoadStopsTask().execute("");
		new LoadStopTimesTask().execute("");
		new LoadRoutesTask().execute("");
		new LoadTripsTask().execute("");
		new LoadShapesTask().execute("");

		Intent intent = new Intent();
		intent.putExtra("routes", routes);
		intent.putExtra("stops", stops);
		intent.putExtra("stopTimes", stopTimes);
		intent.putExtra("trips", trips);
		intent.putExtra("shapes", shapes);

		startActivity(new Intent(this, PontoAPontoActivity.class));
		finish();
	}

	public class LoadStopsTask extends AsyncTask<String, String, String> {
		@Override
		protected String doInBackground(String... arg0) {
			loadStops();
			return null;
		}
	}

	public class LoadStopTimesTask extends AsyncTask<String, String, String> {
		@Override
		protected String doInBackground(String... arg0) {
			loadStopTimes();
			return null;
		}
	}

	public class LoadRoutesTask extends AsyncTask<String, String, String> {
		@Override
		protected String doInBackground(String... arg0) {
			loadRoutes();
			return null;
		}
	}

	public class LoadTripsTask extends AsyncTask<String, String, String> {
		@Override
		protected String doInBackground(String... arg0) {
			loadTrips();
			return null;
		}
	}

	public class LoadShapesTask extends AsyncTask<String, String, String> {
		@Override
		protected String doInBackground(String... arg0) {
			loadShapes();
			return null;
		}
	}

	private void loadStops() {
		stops = new ArrayList<Stops>();
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
			stops.add(stop);
			ILog.i("StopCounter", "" + ++counter);
		}

		line.clear();
	}

	private void loadStopTimes() {
		stopTimes = new ArrayList<StopTimes>();
		int counter = 0;

		InputStream is = getResources().openRawResource(R.raw.stop_times);
		Parser parser = new Parser();
		ArrayList<String> line = parser.generalParseLine(is);

		try {
			is.close();
		} catch (Exception ex) {
			ILog.e(TAG + "loadStopTimes()", ex.getMessage());
		}

		for (String s : line) {
			StopTimes stopTime = new StopTimes(s);
			stopTimes.add(stopTime);
			ILog.i("StopTimesCounter", "" + ++counter);
		}

		line.clear();
	}

	private void loadRoutes() {
		routes = new ArrayList<Route>();
		int counter = 0;

		InputStream is = getResources().openRawResource(R.raw.routes);
		Parser parser = new Parser();
		ArrayList<String> line = parser.generalParseLine(is);

		try {
			is.close();
		} catch (Exception ex) {
			ILog.e(TAG + "loadRoutes()", ex.getMessage());
		}

		for (String s : line) {
			Route route = new Route(s);
			routes.add(route);
			ILog.i("RoutesCounter", "" + ++counter);
		}

		line.clear();
	}

	private void loadTrips() {
		trips = new ArrayList<Trips>();
		int counter = 0;

		InputStream is = getResources().openRawResource(R.raw.trips);
		Parser parser = new Parser();
		ArrayList<String> line = parser.generalParseLine(is);

		for (String s : line) {
			Trips trip = new Trips(s);
			trips.add(trip);
			ILog.i("TripCounter", "" + ++counter);
		}

		line.clear();

		try {
			is.close();
		} catch (Exception ex) {
			ILog.e(TAG + "loadTrips()", ex.getMessage());
		}
	}

	private void loadShapes() {
		shapes = new ArrayList<Shapes>();
		int counter = 0;

		InputStream is = getResources().openRawResource(R.raw.shapes);
		Parser parser = new Parser();
		ArrayList<String> line = parser.generalParseLine(is);

		for (String s : line) {
			Shapes shape = new Shapes(s);
			shapes.add(shape);
			ILog.d("ShapeCounter", "" + ++counter);
		}

		line.clear();

		try {
			is.close();
		} catch (Exception ex) {
			ILog.e(TAG + "loadShapes()", ex.getMessage());
		}
	}
}
