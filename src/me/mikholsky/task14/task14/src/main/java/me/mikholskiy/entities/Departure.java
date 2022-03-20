package me.mikholskiy.entities;

public class Departure {
	private int id;
	private String type;
	private String departureDate;

	public Departure() {
	}

	public Departure(int id, String type, String departureDate) {
		this.id = id;
		this.type = type;
		this.departureDate = departureDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}

	@Override
	public String toString() {
		return "Departure{" +
			"id=" + id +
			", type='" + type + '\'' +
			", departureDate=" + departureDate +
			'}';
	}
}
