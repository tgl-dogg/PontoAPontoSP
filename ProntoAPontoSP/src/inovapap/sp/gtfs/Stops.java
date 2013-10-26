package inovapap.sp.gtfs;

import inovapap.sp.util.Parser;

public class Stops {
	private int stopId;
	private String stopName;
	private String stopDesc;
	private double stopLat;
	private double stopLon;
	
	public Stops(String line){
		String txt = line;
		Parser parse = new Parser();
		
		this.stopId = parse.intParse(txt);
		txt = parse.removeComma(txt);
		
		this.stopName = parse.stringParse(txt);
		txt = parse.removeComma(txt);
		
		this.stopDesc = parse.stringParse(txt);
		txt = parse.removeComma(txt);
		
		this.stopLat = parse.doubleParse(txt);
		txt = parse.removeComma(txt);
		
		this.stopLon = parse.doubleParse(txt);		
	}

	public int getStopId() {
		return stopId;
	}

	public void setStopId(int stopId) {
		this.stopId = stopId;
	}

	public String getStopName() {
		return stopName;
	}

	public void setStopName(String stopName) {
		this.stopName = stopName;
	}

	public String getStopDesc() {
		return stopDesc;
	}

	public void setStopDesc(String stopDesc) {
		this.stopDesc = stopDesc;
	}

	public double getStopLat() {
		return stopLat;
	}

	public void setStopLat(double stopLat) {
		this.stopLat = stopLat;
	}

	public double getStopLon() {
		return stopLon;
	}

	public void setStopLon(double stopLon) {
		this.stopLon = stopLon;
	}
}
