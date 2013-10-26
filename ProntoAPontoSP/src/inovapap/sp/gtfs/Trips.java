package inovapap.sp.gtfs;

import inovapap.sp.util.Parser;

public class Trips {
	private String routeId;
	private String serviceId;
	private String tripId;
	private String tripHeadsign;
	private int directionId;
	private int shapeId;
	
	public Trips(String line){
		String txt = line;
		Parser parse = new Parser();
		
		this.routeId = parse.stringParse(txt);
		txt = parse.removeComma(txt);
		
		this.serviceId = parse.stringParse(txt);
		txt = parse.removeComma(txt);
		
		this.tripId = parse.stringParse(txt);
		txt = parse.removeComma(txt);
		
		this.tripHeadsign = parse.stringParse(txt);
		txt = parse.removeComma(txt);
		
		this.directionId = parse.intParse(txt);
		txt = parse.removeComma(txt);
		
		this.shapeId = parse.intParse(txt);
	}

	public String getRouteId() {
		return routeId;
	}

	public void setRouteId(String routeId) {
		this.routeId = routeId;
	}

	public String getServiceId() {
		return serviceId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

	public String getTripId() {
		return tripId;
	}

	public void setTripId(String tripId) {
		this.tripId = tripId;
	}

	public String getTripHeadsign() {
		return tripHeadsign;
	}

	public void setTripHeadsign(String tripHeadsign) {
		this.tripHeadsign = tripHeadsign;
	}

	public int getDirectionId() {
		return directionId;
	}

	public void setDirectionId(int directionId) {
		this.directionId = directionId;
	}

	public int getShapeId() {
		return shapeId;
	}

	public void setShapeId(int shapeId) {
		this.shapeId = shapeId;
	}

}
