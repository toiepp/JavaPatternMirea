package me.mikholskiy.task18.repositories;

import me.mikholskiy.task18.domains.Departure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;

@Repository("departureRepository")
public interface DepartureRepository extends JpaRepository<Departure, Integer> {
	Optional<Departure> getByType(String type);

	Optional<Departure> getByDate(String date);

	Collection<Departure> getAllByType(String type);

	Collection<Departure> getAllByDate(String date);

	Collection<Departure> getAllByTypeAndDate(String type, String date);

	void deleteById(Integer id);
}
