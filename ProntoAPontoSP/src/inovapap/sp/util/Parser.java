package inovapap.sp.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Parser {
	private final String TAG = "Parser ";
	
	// File file = new File("file.txt");
	public String generalParseLine(File file) {
		BufferedReader reader = null;
		String text = null;

		try {
			reader = new BufferedReader(new FileReader(file));

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
			i = Integer.valueOf(txt);
		} catch (Exception ex) {
			ILog.e(TAG + "intParse", ex.getMessage());
		}

		return i;
	}

	public float floatParse(String txt) {
		float f = Float.NaN;

		try {
			f = Float.valueOf(txt);
		} catch (Exception ex) {
			ILog.e(TAG + "floatParse", ex.getMessage());
		}

		return f;
	}

	public double doubleParse(String txt) {
		Double d = Double.NaN;

		try {
			d = Double.valueOf(txt);
		} catch (Exception ex) {
			ILog.e(TAG + "doubleParse", ex.getMessage());
		}

		return d;
	}

	public String stringParse(String txt) {
		String s = null;

		try {
			s = txt.substring(1, txt.length() - 2);
		} catch (Exception ex) {
			ILog.e(TAG + "stringParse", ex.getMessage());
		}

		return s;
	}
	
	public String removeComma(String txt){
		String s = txt;
		int i = txt.indexOf(',');
		
		if(i > 0){
			s = txt.substring(i+1);
		}
		
		return s;				
	}
}
