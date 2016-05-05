package com.quangnn.getdatacafe;

public class NewsItem {
	private String name, vicinity, lat, lng;

	public NewsItem(String name, String vicinity, String lat, String lng) {
		super();
		this.name = name;
		this.vicinity = vicinity;
		this.lat = lat;
		this.lng = lng;
	}

	public String getName() {
		return name;
	}

	public String getVicinity() {
		return vicinity;
	}

	public String getLat() {
		return lat;
	}

	public String getLng() {
		return lng;
	}
	
}
