package me.mikholskiy.task18.domains;

import javax.persistence.*;

@Entity
@Table(name = "departures")
public class Departure {
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column
	private String type;

	@Column
	private String date;

	@ManyToOne(cascade = {
		CascadeType.PERSIST, CascadeType.DETACH,
		CascadeType.REFRESH, CascadeType.MERGE})
	@JoinColumn(name = "departure_post_office_id")
	private PostOffice departurePostOffice;

	public Departure() {
	}

	public Integer getId() {
		return id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public PostOffice getDeparturePostOffice() {
		return departurePostOffice;
	}

	public void setDeparturePostOffice(PostOffice departurePostOffice) {
		this.departurePostOffice = departurePostOffice;
	}

	@Override
	public String toString() {
		return "Departure{" +
			"id=" + id +
			", type='" + type + '\'' +
			", date='" + date + '\'' +
			", departurePostOffice=" + departurePostOffice +
			'}';
	}
}
