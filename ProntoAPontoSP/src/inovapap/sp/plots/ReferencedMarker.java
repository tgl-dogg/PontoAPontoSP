package inovapap.sp.plots;

import com.google.android.gms.maps.model.Marker;

public class ReferencedMarker {
	Marker marker;
	int id;

	public void add(Marker mk, int i) {
		marker = mk;
		id = i;
	}

	public boolean find(Marker mk) {
		return mk.equals(marker);
	}

	public void addMarker(Marker mk) {
		this.marker = mk;
	}

	public int getId() {
		return id;
	}
}
