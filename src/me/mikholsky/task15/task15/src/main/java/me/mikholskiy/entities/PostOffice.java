package me.mikholskiy.entities;

import javax.persistence.*;

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

	@Override
	public String toString() {
		return "PostOffice{" +
			"id=" + id +
			", name='" + name + '\'' +
			", cityName='" + cityName + '\'' +
			'}';
	}
}
