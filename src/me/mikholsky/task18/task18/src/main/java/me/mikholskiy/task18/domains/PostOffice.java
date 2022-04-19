package me.mikholskiy.task18.domains;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "post_offices")
public class PostOffice {
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column
	private String name;

	@Column(name = "city_name")
	private String cityName;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "departure_post_office_id")
	private final List<Departure> departures = new ArrayList<>();

	public PostOffice() {
	}

	public PostOffice(String name, String cityName) {
		this.name = name;
		this.cityName = cityName;
	}

	public Integer getId() {
		return id;
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

	public void addDeparture(Departure... toAdd) {
		this.departures.addAll(List.of(toAdd));
	}

	@Override
	public String toString() {
		return "PostOffice{" +
			"id=" + id +
			", name='" + name + '\'' +
			", cityName='" + cityName + '\'' +
			", departures=" + departures +
			'}';
	}
}
