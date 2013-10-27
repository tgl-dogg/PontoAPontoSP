package inovapap.sp.util;

import inovapap.sp.gtfs.Shapes;
import inovapap.sp.gtfs.StopTimes;
import inovapap.sp.gtfs.Trips;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Parser {
	private final String TAG = "Parser ";

	// File file = new File("file.txt");
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

	public ArrayList<StopTimes> specificStopTimeParseLine(InputStream file,
			int id) {
		BufferedReader reader = null;
		ArrayList<StopTimes> spt = new ArrayList<StopTimes>();

		try {
			reader = new BufferedReader(new InputStreamReader(file));

			int cont = 0;
			while (true) {
				String s = reader.readLine();
				if (s != null) {
					StopTimes stopTime = new StopTimes(s);

					if (stopTime.getStopId() == id) {
						spt.add(stopTime);
						ILog.w("StopTimesValidator", "Added: " + id);
					}
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

		return spt;
	}

	public ArrayList<Trips> specificTripParseLine(InputStream file, String id) {
		BufferedReader reader = null;
		ArrayList<Trips> trips = new ArrayList<Trips>();

		try {
			reader = new BufferedReader(new InputStreamReader(file));

			int cont = 0;
			while (true) {
				String s = reader.readLine();
				if (s != null) {
					Trips trip = new Trips(s);

					if (trip.getTripId().equals(id)) {
						trips.add(trip);
						ILog.w("TripsValidator", "Added: " + id);
					}
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

		return trips;
	}

	public ArrayList<Shapes> specificShapeParseLine(InputStream file,
			ArrayList<Integer> id) {
		BufferedReader reader = null;
		ArrayList<Shapes> shapes = new ArrayList<Shapes>();

		try {
			reader = new BufferedReader(new InputStreamReader(file));

			int cont = 0;
			while (true) {
				String s = reader.readLine();
				if (s != null) {
					Shapes shape = new Shapes(s);

					for (int i : id) {
						if (shape.getShapeId() == i) {
							shapes.add(shape);
							ILog.w("TripsValidator", "Added: " + id);
						}
					}
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

		return shapes;
	}

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
