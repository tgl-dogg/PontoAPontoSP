package inovapap.sp;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import inovapap.sp.gtfs.Stops;
import inovapap.sp.util.Geral;
import inovapap.sp.util.ILog;
import inovapap.sp.util.Parser;
import android.content.pm.ActivityInfo;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

public class PontoAPontoActivity extends FragmentActivity {
	private final String TAG = "PontoAPontoActivity ";

	@Override
	protected void onCreate(Bundle b) {
		try {
			super.onCreate(b);
			
//			InputStream is = getResources().openRawResource(R.raw.stops);
//			Parser parser = new Parser();
//			String line = parser.generalParseLine(is);
//			Stops stop = new Stops(line);
			
			setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		} catch (Exception ex) {
			ILog.e(TAG + "onCreate()", ex.getMessage());
		}
	}
}
