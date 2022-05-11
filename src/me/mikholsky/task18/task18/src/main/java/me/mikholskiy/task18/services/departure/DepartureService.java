package me.mikholskiy.task18.services.departure;

import me.mikholskiy.task18.domains.Departure;

import java.util.Collection;
import java.util.Optional;

public interface DepartureService {
	void save(Departure departure);

	Optional<Departure> getById(Integer id);

	Optional<Departure> getByType(String type);

	Optional<Departure> getByDate(String date);

	Collection<Departure> getAll();

	Collection<Departure> getAllByType(String type);

	Collection<Departure> getAllByDate(String date);

	void deleteById(Integer id);
}
