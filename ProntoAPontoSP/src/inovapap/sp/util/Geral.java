package inovapap.sp.util;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;

public class Geral {
	public static Builder showNotification(final Context context, int icon,
			String title, String message) {

		AlertDialog.Builder dialog = new AlertDialog.Builder(context);
		dialog.setIcon(icon);
		dialog.setTitle(title);
		dialog.setMessage(message);

		return dialog;
	}

	public static Builder showOkNotification(final Context context, int icon,
			String title, String message,
			DialogInterface.OnClickListener okListener) {
		AlertDialog.Builder dialog = showNotification(context, icon, title,
				message);
		dialog.setNeutralButton(context.getString(android.R.string.ok),
				okListener);

		return dialog;
	}

	public static Builder showYesNoNotification(final Context context,
			int icon, String title, String message, String yesButton,
			DialogInterface.OnClickListener yesListener, String noButton,
			DialogInterface.OnClickListener noListener) {

		AlertDialog.Builder dialog = showNotification(context, icon, title,
				message);
		dialog.setCancelable(false);
		dialog.setPositiveButton(yesButton, yesListener);
		dialog.setNegativeButton(noButton, noListener);

		return dialog;
	}
}