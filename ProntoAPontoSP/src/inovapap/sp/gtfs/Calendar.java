package inovapap.sp.gtfs;

import inovapap.sp.util.Parser;

public class Calendar {
	private String serviceId;
	private int monday;
	private int tuesday;
	private int wednesday;
	private int thursday;
	private int friday;
	private int saturday;
	private int sunday;
	private String start_date;
	private String end_date;

	public Calendar(String line) {
		String txt = line;
		Parser parse = new Parser();

		this.serviceId = parse.stringParse(txt);
		txt = parse.removeComma(txt);

		this.monday = parse.intParse(txt);
		txt = parse.removeComma(txt);
		
		this.tuesday = parse.intParse(txt);
		txt = parse.removeComma(txt);
		
		this.wednesday = parse.intParse(txt);
		txt = parse.removeComma(txt);
		
		this.thursday = parse.intParse(txt);
		txt = parse.removeComma(txt);
		
		this.friday = parse.intParse(txt);
		txt = parse.removeComma(txt);
		
		this.saturday = parse.intParse(txt);
		txt = parse.removeComma(txt);
		
		this.sunday = parse.intParse(txt);
		txt = parse.removeComma(txt);
		
		this.start_date = parse.stringParse(txt);
		txt = parse.removeComma(txt);
		
		this.end_date = parse.stringParse(txt);		
	}

	public String getServiceId() {
		return serviceId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

	public int getMonday() {
		return monday;
	}

	public void setMonday(int monday) {
		this.monday = monday;
	}

	public int getTuesday() {
		return tuesday;
	}

	public void setTuesday(int tuesday) {
		this.tuesday = tuesday;
	}

	public int getWednesday() {
		return wednesday;
	}

	public void setWednesday(int wednesday) {
		this.wednesday = wednesday;
	}

	public int getThursday() {
		return thursday;
	}

	public void setThursday(int thursday) {
		this.thursday = thursday;
	}

	public int getFriday() {
		return friday;
	}

	public void setFriday(int friday) {
		this.friday = friday;
	}

	public int getSaturday() {
		return saturday;
	}

	public void setSaturday(int saturday) {
		this.saturday = saturday;
	}

	public int getSunday() {
		return sunday;
	}

	public void setSunday(int sunday) {
		this.sunday = sunday;
	}

	public String getStart_date() {
		return start_date;
	}

	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}

	public String getEnd_date() {
		return end_date;
	}

	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}
}
