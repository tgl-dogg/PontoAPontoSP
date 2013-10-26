package inovapap.sp;

import inovapap.sp.util.ILog;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
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

			Handler handler = new Handler();
			handler.postDelayed(this, 3000);
		} catch (Exception ex) {
			ILog.e(TAG + "onCreate()", ex.getMessage());
		}
	}

	@Override
	public void run() {
		startActivity(new Intent(this, PontoAPontoActivity.class));
		finish();
	}
}
