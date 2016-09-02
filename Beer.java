package com.beerzoo;

public class Beer {
	
	private int beerID = 0;
	private String name = null;
	private String countryOfOrigin = null;
	private String style = null;
	private double abv = 0.0;
	
	public Beer() {
		super();
	}

	public int getBeerID() {
		return beerID;
	}

	public void setBeerID(int beerID) {
		this.beerID = beerID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountryOfOrigin() {
		return countryOfOrigin;
	}

	public void setCountryOfOrigin(String countryOfOrigin) {
		this.countryOfOrigin = countryOfOrigin;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public double getAbv() {
		return abv;
	}

	public void setAbv(double abv) {
		this.abv = abv;
	}

	@Override
	public String toString() {
		return "Beer [beerID=" + beerID + ", name=" + name + ", countryOfOrigin=" + countryOfOrigin + ", style=" + style
				+ ", abv=" + abv + "]";
	}

} // class
