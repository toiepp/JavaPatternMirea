package me.mikholskiy.task18.repositories;

import me.mikholskiy.task18.domains.PostOffice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;

@Repository
public interface PostOfficeRepository extends JpaRepository<PostOffice, Integer> {
	Optional<PostOffice> getByName(String name);

	Optional<PostOffice> getByCityName(String cityName);

	Optional<PostOffice> getByNameAndCityName(String name, String cityName);

	Collection<PostOffice> getAllByName(String name);

	Collection<PostOffice> getAllByCityName(String name);

	Collection<PostOffice> getAllByNameAndCityName(String name, String cityName);

	void deleteById(Integer id);
}
