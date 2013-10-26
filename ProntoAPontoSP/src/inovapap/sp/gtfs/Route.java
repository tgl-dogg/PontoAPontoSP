package inovapap.sp.gtfs;

import inovapap.sp.util.Parser;

public class Route {
	private int routeId;
	private int agencyId;
	private String routeShortName;
	private String routeLongName;
	private int routeType;
	private String routeColor;
	private String routeTextColor;

	public Route(String line) {
		String txt = line;
		Parser parse = new Parser();

		this.routeId = parse.intParse(txt);
		txt = parse.removeComma(txt);

		this.agencyId = parse.intParse(txt);
		txt = parse.removeComma(txt);

		this.routeShortName = parse.stringParse(txt);
		txt = parse.removeComma(txt);

		this.routeLongName = parse.stringParse(txt);
		txt = parse.removeComma(txt);

		this.routeType = parse.intParse(txt);
		txt = parse.removeComma(txt);

		this.routeColor = parse.stringParse(txt);
		txt = parse.removeComma(txt);

		this.routeTextColor = parse.stringParse(txt);
	}

	public String getRouteTextColor() {
		return routeTextColor;
	}

	public void setRouteTextColor(String routeTextColor) {
		this.routeTextColor = routeTextColor;
	}

	public String getRoutecolor() {
		return routeColor;
	}

	public void setRoutecolor(String routecolor) {
		this.routeColor = routecolor;
	}

	public int getRouteType() {
		return routeType;
	}

	public void setRouteType(int routeType) {
		this.routeType = routeType;
	}

	public String getRouteLongName() {
		return routeLongName;
	}

	public void setRouteLongName(String routeLongName) {
		this.routeLongName = routeLongName;
	}

	public String getRouteShortName() {
		return routeShortName;
	}

	public void setRouteShortName(String routeShortName) {
		this.routeShortName = routeShortName;
	}

	public int getAgencyId() {
		return agencyId;
	}

	public void setAgencyId(int agencyId) {
		this.agencyId = agencyId;
	}

	public int getRouteId() {
		return routeId;
	}

	public void setRouteId(int routeId) {
		this.routeId = routeId;
	}

}
