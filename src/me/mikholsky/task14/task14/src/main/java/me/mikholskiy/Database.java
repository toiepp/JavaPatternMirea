package me.mikholskiy;

import me.mikholskiy.entities.Departure;
import me.mikholskiy.entities.PostOffice;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;

public class Database {
	public static int DEPARTURE_ID = 0;
	public static int POSTOFFICE_ID = 0;
	private static final List<Departure> departures = new ArrayList<>();
	private static final List<PostOffice> postOffices = new ArrayList<>();

	static {
		departures.addAll(Arrays.asList(
			new Departure(++DEPARTURE_ID, "Train", "2022-04-24"),
			new Departure(++DEPARTURE_ID, "Truck", "2022-04-21"),
			new Departure(++DEPARTURE_ID, "Truck", "2022-03-29"),
			new Departure(++DEPARTURE_ID, "Aircraft", "2022-05-10")
		));

		postOffices.addAll(Arrays.asList(
			new PostOffice(++POSTOFFICE_ID, "FedEx", "Singapore"),
			new PostOffice(++POSTOFFICE_ID, "CDEK", "Moscow"),
			new PostOffice(++POSTOFFICE_ID, "ACT", "New York")
		));
	}

	public static void addDeparture(Departure departure) {
		departures.add(departure);
	}

	public static void deleteDeparture(int id) {
		departures.removeIf(d -> d.getId() == id);
	}

	public static List<Departure> getAllDepartures() {
		return departures;
	}

	public static void addPostOffice(PostOffice postOffice) {
		postOffices.add(postOffice);
	}

	public static void deletePostOffice(int id) {
		postOffices.removeIf(p -> p.getId() == id);
	}

	public static List<PostOffice> getAllPostOffices() {
		return postOffices;
	}
}
