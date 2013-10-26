package inovapap.sp.gtfs;

import inovapap.sp.util.Parser;

public class FareRules {
	private String fareId;
	private String routeId;
	private String originId;
	private String destinationId;
	private String containsId;

	public FareRules(String line) {
		String txt = line;
		Parser parse = new Parser();

		this.fareId = parse.stringParse(txt);
		txt = parse.removeComma(txt);
		
		this.routeId = parse.stringParse(txt);
		txt = parse.removeComma(txt);
		
		this.originId = parse.stringParse(txt);
		txt = parse.removeComma(txt);
		
		this.destinationId = parse.stringParse(txt);
		txt = parse.removeComma(txt);
		
		this.containsId = parse.stringParse(txt);
	}

	public String getFareId() {
		return fareId;
	}

	public void setFareId(String fareId) {
		this.fareId = fareId;
	}

	public String getRouteId() {
		return routeId;
	}

	public void setRouteId(String routeId) {
		this.routeId = routeId;
	}

	public String getOriginId() {
		return originId;
	}

	public void setOriginId(String originId) {
		this.originId = originId;
	}

	public String getDestinationId() {
		return destinationId;
	}

	public void setDestinationId(String destinationId) {
		this.destinationId = destinationId;
	}

	public String getContainsId() {
		return containsId;
	}

	public void setContainsId(String containsId) {
		this.containsId = containsId;
	}
}
