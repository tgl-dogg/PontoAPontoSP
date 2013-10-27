package inovapap.sp;

import inovapap.sp.util.ILog;
import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;

public class AlertaDemoActivity extends Activity implements OnClickListener {
	private final String TAG = "AlertaDemoActivity ";
	RelativeLayout rlMap;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		try {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.alerta_layout1);
			setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

			rlMap = (RelativeLayout) findViewById(R.id.map_relative_layout);
			rlMap.setOnClickListener(this);
		} catch (Exception ex) {
			ILog.e(TAG + "onCreate()", ex.getMessage());
		}
	}

	@Override
	public void onClick(View v) {
		setContentView(R.layout.alerta_layout2);
	}
}
