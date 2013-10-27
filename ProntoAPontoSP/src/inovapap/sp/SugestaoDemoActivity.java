package inovapap.sp;

import inovapap.sp.util.ILog;
import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;

public class SugestaoDemoActivity extends Activity {
	private final String TAG = "SugestaoDemoActivity ";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		try {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.sugestao_layout);
			setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		} catch (Exception ex) {
			ILog.e(TAG + "onCreate()", ex.getMessage());
		}
	}
}
