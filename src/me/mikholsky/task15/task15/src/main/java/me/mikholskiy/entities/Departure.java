package me.mikholskiy.entities;

import javax.persistence.*;

@Entity
@Table(name = "departures")
public class Departure {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "type")
	private String type;
	@Column(name = "date")
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
