package inovapap.sp.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Parser {
	private final String TAG = "Parser ";

	// File file = new File("file.txt");
	/**
	 * Converte um arquivo de texto no formato padrão gtfs em uma ArrayList de
	 * Strings.
	 * 
	 * @param file
	 *            Arquivo a ser convertido, no padrão gtfs.
	 *            <p>
	 * 
	 * @return Uma ArrayList onde cada objeto é uma linha do arquivo de texto,
	 *         ou vazia caso o arquivo de entrada seja inválido.
	 */
	public ArrayList<String> generalParseLine(InputStream file) {
		BufferedReader reader = null;
		ArrayList<String> text = new ArrayList<String>();

		try {
			reader = new BufferedReader(new InputStreamReader(file));

			int cont = 0;
			while (true) {
				String s = reader.readLine();
				if (s != null) {
					text.add(s);
				} else {
					break;
				}
				ILog.i(TAG + "parsing line", "" + ++cont);
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

	/**
	 * Converte em inteiro o próximo valor de uma linha de texto em padrão gtfs.
	 * 
	 * @param txt
	 *            Linha de texto no padrão gtfs.
	 *            <p>
	 * 
	 * @return O inteiro lido, ou -1 em caso de erro. *
	 */
	public int intParse(String txt) {
		int i = -1;

		try {
			if (txt.indexOf('\"') == 0) {
				txt = txt.substring(1);
				txt = txt.substring(0, txt.indexOf('\"'));
			}

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

	/**
	 * Converte em ponto flutuante o próximo valor de uma linha de texto em
	 * padrão gtfs.
	 * 
	 * @param txt
	 *            Linha de texto no padrão gtfs.
	 *            <p>
	 * 
	 * @return O valor lido, ou NaN em caso de erro. *
	 */
	public float floatParse(String txt) {
		float f = Float.NaN;

		try {
			if (txt.indexOf('\"') == 0) {
				txt = txt.substring(1);
				txt = txt.substring(0, txt.indexOf('\"'));
			}

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

	/**
	 * Converte em ponto flutuante de dupla precisão o próximo valor de uma
	 * linha de texto em padrão gtfs.
	 * 
	 * @param txt
	 *            Linha de texto no padrão gtfs.
	 *            <p>
	 * 
	 * @return O valor lido, ou NaN em caso de erro. *
	 */
	public double doubleParse(String txt) {
		Double d = Double.NaN;

		try {
			if (txt.indexOf('\"') == 0) {
				txt = txt.substring(1);
				txt = txt.substring(0, txt.indexOf('\"'));
			}

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

	/**
	 * Converte em String o próximo valor de uma linha de texto em padrão gtfs.
	 * 
	 * @param txt
	 *            Linha de texto no padrão gtfs.
	 *            <p>
	 * 
	 * @return A String encontrada, ou null em caso de erro. *
	 */
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

	/**
	 * Remove todos os campos de um arquivo de texto padrão gtfs até encontrar
	 * uma vírgula.
	 * 
	 * @param txt
	 *            Linha de texto no padrão gtfs.
	 *            <p>
	 * 
	 * @return A String de entrada com valores removidos até a primeira vírgula
	 *         encontrada. *
	 */
	public String removeComma(String txt) {
		String s = txt;

		if (s.indexOf('\"') == 0) {
			txt = txt.substring(1);
			s = txt.substring(txt.indexOf('\"'));
		}

		int i = s.indexOf(',');

		if (i != -1) {
			s = s.substring(i + 1);
		}

		return s;
	}
}
