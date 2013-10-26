package inovapap.sp.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Parser {
	private final String TAG = "Parser ";

	// File file = new File("file.txt");
	public String generalParseLine(InputStream file) {
		BufferedReader reader = null;
		String text = null;

		try {
			reader = new BufferedReader(new InputStreamReader(file));

			if ((text = reader.readLine()) != null) {
			}
		} catch (FileNotFoundException ex) {
			ILog.e(TAG + "generalParse", ex.getMessage());
		} catch (IOException ex) {
			ILog.e(TAG + "generalParse", ex.getMessage());
		} finally {
			try {
				if (reader != null) {
					reader.close();
				}
			} catch (IOException ex) {
				ILog.e(TAG + "generalParse", ex.getMessage());
			}
		}

		return text;
	}

	public int intParse(String txt) {
		int i = -1;

		try {
			int comma = txt.indexOf(',');

			if (comma > 0) {
				i = Integer.valueOf(txt.substring(0, comma));
			} else {
				i = Integer.valueOf(txt);
			}
		} catch (Exception ex) {
			ILog.e(TAG + "intParse", ex.getMessage());
		}

		return i;
	}

	public float floatParse(String txt) {
		float f = Float.NaN;

		try {
			int comma = txt.indexOf(',');

			if (comma > 0) {
				f = Float.valueOf(txt.substring(0, comma));
			} else {
				f = Float.valueOf(txt);
			}
		} catch (Exception ex) {
			ILog.e(TAG + "floatParse", ex.getMessage());
		}

		return f;
	}

	public double doubleParse(String txt) {
		Double d = Double.NaN;

		try {
			int comma = txt.indexOf(',');

			if (comma > 0) {
				d = Double.valueOf(txt.substring(0, comma));
			} else {
				d = Double.valueOf(txt);
			}
		} catch (Exception ex) {
			ILog.e(TAG + "doubleParse", ex.getMessage());
		}

		return d;
	}

	public String stringParse(String txt) {
		String s = null;

		try {
			s = txt;

			if (s.indexOf('\"') != -1) {
				txt = txt.substring(1);
				s = txt.substring(0, txt.indexOf('\"'));
			} else {
				int comma = txt.indexOf(',');

				if (comma > 0) {
					s = txt.substring(0, comma);
				}
			}
		} catch (Exception ex) {
			ILog.e(TAG + "stringParse", ex.getMessage());
		}

		return s;
	}

	public String removeComma(String txt) {
		String s = txt;
		int i = txt.indexOf(',');

		if (i > 0) {
			s = txt.substring(i + 1);
		}

		return s;
	}
}
