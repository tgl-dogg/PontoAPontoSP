package inovapap.sp.gtfs;

import inovapap.sp.util.Parser;

public class Frequencies {
	private String tripId;
	private String startTime;
	private String endTime;
	private int headwaySecs;

	public Frequencies(String line){
		String txt = line;
		Parser parse = new Parser();
		
		this.tripId = parse.stringParse(txt);
		txt = parse.removeComma(txt);
		
		this.startTime = parse.stringParse(txt);
		txt = parse.removeComma(txt);
		
		this.endTime = parse.stringParse(txt);
		txt = parse.removeComma(txt);
		
		this.headwaySecs = parse.intParse(txt);		
	}	
	
	public String getTripId() {
		return tripId;
	}

	public void setTripId(String tripId) {
		this.tripId = tripId;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public int getHeadwaySecs() {
		return headwaySecs;
	}

	public void setHeadwaySecs(int headwaySecs) {
		this.headwaySecs = headwaySecs;
	}
}
