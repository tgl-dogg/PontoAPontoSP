package inovapap.sp.gtfs;

import inovapap.sp.util.Parser;

public class Shapes {
	private int shapeId;
	private double shapePtLat;
	private double shapePtLon;
	private int shapePtSequence;
	private double shapeDistTraveled;

	public Shapes(String line) {
		String txt = line;
		Parser parse = new Parser();

		this.shapeId = parse.intParse(txt);
		txt = parse.removeComma(txt);

		this.shapePtLat = parse.doubleParse(txt);
		txt = parse.removeComma(txt);

		this.shapePtLon = parse.doubleParse(txt);
		txt = parse.removeComma(txt);
		
		this.shapePtSequence = parse.intParse(txt);
		txt = parse.removeComma(txt);
		
		this.shapeDistTraveled = parse.doubleParse(txt);
	}

	public int getShapeId() {
		return shapeId;
	}

	public void setShapeId(int shapeId) {
		this.shapeId = shapeId;
	}

	public double getShapePtLat() {
		return shapePtLat;
	}

	public void setShapePtLat(double shapePtLat) {
		this.shapePtLat = shapePtLat;
	}

	public double getShapePtLon() {
		return shapePtLon;
	}

	public void setShapePtLon(double shapePtLon) {
		this.shapePtLon = shapePtLon;
	}

	public int getShapePtSequence() {
		return shapePtSequence;
	}

	public void setShapePtSequence(int shapePtSequence) {
		this.shapePtSequence = shapePtSequence;
	}

	public double getShapeDistTraveled() {
		return shapeDistTraveled;
	}

	public void setShapeDistTraveled(double shapeDistTraveled) {
		this.shapeDistTraveled = shapeDistTraveled;
	}
}
