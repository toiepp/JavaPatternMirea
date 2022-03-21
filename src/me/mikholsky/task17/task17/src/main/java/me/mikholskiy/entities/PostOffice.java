package me.mikholskiy.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "post_offices")
public class PostOffice {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "name")
	private String name;
	@Column(name = "city_name")
	private String cityName;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "departure_post_office_id")
	private final List<Departure> departures = new ArrayList<>();

	public PostOffice() {
	}

	public PostOffice(int id, String name, String cityName) {
		this.id = id;
		this.name = name;
		this.cityName = cityName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public List<Departure> getDepartures() {
		return departures;
	}

	public void addDeparture(Departure departure) {
		departures.add(departure);
	}

	@Override
	public String toString() {
		return "PostOffice{" +
			"id=" + id +
			", name='" + name + '\'' +
			", cityName='" + cityName + '\'' +
			'}';
	}
}
