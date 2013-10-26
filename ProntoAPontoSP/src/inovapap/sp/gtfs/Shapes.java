package inovapap.sp.gtfs;

import inovapap.sp.util.Parser;

public class Shapes {
	private int shapeId;
	private float shapePtLat;
	private float shapePtLon;
	private int shapePtSequence;
	private float shapeDistTraveled;

	public Shapes(String line) {
		String txt = line;
		Parser parse = new Parser();

		this.shapeId = parse.intParse(txt);
		txt = parse.removeComma(txt);

		this.shapePtLat = parse.floatParse(txt);
		txt = parse.removeComma(txt);

		this.shapePtLon = parse.floatParse(txt);
		txt = parse.removeComma(txt);
		
		this.shapePtSequence = parse.intParse(txt);
		txt = parse.removeComma(txt);
		
		this.shapeDistTraveled = parse.floatParse(txt);
	}

	public int getShapeId() {
		return shapeId;
	}

	public void setShapeId(int shapeId) {
		this.shapeId = shapeId;
	}

	public float getShapePtLat() {
		return shapePtLat;
	}

	public void setShapePtLat(float shapePtLat) {
		this.shapePtLat = shapePtLat;
	}

	public float getShapePtLon() {
		return shapePtLon;
	}

	public void setShapePtLon(float shapePtLon) {
		this.shapePtLon = shapePtLon;
	}

	public int getShapePtSequence() {
		return shapePtSequence;
	}

	public void setShapePtSequence(int shapePtSequence) {
		this.shapePtSequence = shapePtSequence;
	}

	public float getShapeDistTraveled() {
		return shapeDistTraveled;
	}

	public void setShapeDistTraveled(float shapeDistTraveled) {
		this.shapeDistTraveled = shapeDistTraveled;
	}
}
