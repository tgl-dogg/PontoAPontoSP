package inovapap.sp.util;

import android.util.Log;

public class ILog {

	public static void v(String tag, String msg) {
		if (msg == null) {
			msg = "NullPointerException";
		} else if (msg.isEmpty()) {
			msg = "A exception veio sem mensagem";
		}

		Log.v(tag, msg);
	}

	public static void i(String tag, String msg) {
		if (msg == null) {
			msg = "NullPointerException";
		} else if (msg.isEmpty()) {
			msg = "A exception veio sem mensagem";
		}

		Log.i(tag, msg);
	}

	public static void e(String tag, String msg) {
		if (msg == null) {
			msg = "NullPointerException";
		} else if (msg.isEmpty()) {
			msg = "A exception veio sem mensagem";
		}

		Log.e(tag, msg);
	}

	public static void e(String tag, String msg, Throwable tr) {
		if (msg == null) {
			msg = "NullPointerException";
		} else if (msg.isEmpty()) {
			msg = "A exception veio sem mensagem";
		}

		Log.e(tag, msg, tr);
	}

	public static void d(String tag, String msg) {
		if (msg == null) {
			msg = "NullPointerException";
		} else if (msg.isEmpty()) {
			msg = "A exception veio sem mensagem";
		}

		Log.d(tag, msg);
	}

	public static void w(String tag, String msg) {
		if (msg == null) {
			msg = "NullPointerException";
		} else if (msg.isEmpty()) {
			msg = "A exception veio sem mensagem";
		}

		Log.w(tag, msg);
	}
}
