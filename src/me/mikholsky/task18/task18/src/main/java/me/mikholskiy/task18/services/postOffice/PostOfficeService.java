package me.mikholskiy.task18.services.postOffice;

import me.mikholskiy.task18.domains.PostOffice;

import java.util.Collection;
import java.util.Optional;

public interface PostOfficeService {
	void save(PostOffice departure);

	Optional<PostOffice> getByName(String name);

	Optional<PostOffice> getByCityName(String cityName);

	Optional<PostOffice> getByNameAndCityName(String name, String cityName);

	Collection<PostOffice> getAllByName(String name);

	Collection<PostOffice> getAllByCityName(String cityName);

	Collection<PostOffice> getAllByNameAndCityName(String name, String cityName);

	void deleteById(Integer id);}
