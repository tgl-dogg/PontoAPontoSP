package inovapap.sp;

import inovapap.sp.util.ILog;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

public class PontoAPontoActivity extends FragmentActivity {
	private final String TAG = "PontoAPontoActivity ";

	@Override
	protected void onCreate(Bundle b) {
		try {
			super.onCreate(b);
			
			
			setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		} catch (Exception ex) {
			ILog.e(TAG + "onCreate()", ex.getMessage());
		}
	}

}
