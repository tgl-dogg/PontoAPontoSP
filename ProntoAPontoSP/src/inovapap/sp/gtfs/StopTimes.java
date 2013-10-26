package inovapap.sp.gtfs;

import inovapap.sp.util.Parser;

public class StopTimes {
	private String tripId;
	private String arrivalTime;
	private String departureTime;
	private int stopId;
	private int stopSequence;

	public StopTimes(String line) {
		String txt = line;
		Parser parser = new Parser();

		this.tripId = parser.stringParse(txt);
		txt = parser.removeComma(txt);

		this.arrivalTime = parser.stringParse(txt);
		txt = parser.removeComma(txt);

		this.departureTime = parser.stringParse(txt);
		txt = parser.removeComma(txt);

		this.stopId = parser.intParse(txt);
		txt = parser.removeComma(txt);

		this.stopSequence = parser.intParse(txt);
	}

	public String getTripId() {
		return tripId;
	}

	public void setTripId(String tripId) {
		this.tripId = tripId;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public int getStopId() {
		return stopId;
	}

	public void setStopId(int stopId) {
		this.stopId = stopId;
	}

	public int getStopSequence() {
		return stopSequence;
	}

	public void setStopSequence(int stopSequence) {
		this.stopSequence = stopSequence;
	}
}
