package me.mikholskiy.task18.services.postOffice;

import me.mikholskiy.task18.domains.PostOffice;
import me.mikholskiy.task18.repositories.PostOfficeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service("postOfficeService")
public class PostOfficeServiceSimpleImpl implements PostOfficeService {
	private PostOfficeRepository repository;
	private static final Logger log = LoggerFactory.getLogger(PostOfficeServiceSimpleImpl.class);

	@Autowired
	public void setRepository(PostOfficeRepository repository) {
		this.repository = repository;
	}

	@Override
	public void save(PostOffice postOffice) {
		repository.save(postOffice);
		log.info("Post office {" + postOffice + "} saved");
	}

	@Override
	public Optional<PostOffice> getByName(String name) {
		log.info("Retrieving post office by name: {" + name + "}");
		return repository.getByName(name);
	}

	@Override
	public Optional<PostOffice> getByCityName(String cityName) {
		log.info("Retrieving post office by city name: {" + cityName + "}");
		return repository.getByName(cityName);
	}

	@Override
	public Optional<PostOffice> getByNameAndCityName(String name, String cityName) {
		log.info("Retrieving post office by name: {" + name + "} and city name: {" + cityName +"}");
		return repository.getByNameAndCityName(name, cityName);
	}

	@Override
	public Collection<PostOffice> getAll() {
		log.info("Retrieving all post offices");
		return repository.findAll();
	}

	@Override
	public Collection<PostOffice> getAllByName(String name) {
		log.info("Retrieving all post offices by name: {" + name + "}");
		return repository.getAllByName(name);
	}

	@Override
	public Collection<PostOffice> getAllByCityName(String cityName) {
		log.info("Retrieving all post offices by city name: {" + cityName + "}");
		return repository.getAllByCityName(cityName);
	}

	@Override
	public Collection<PostOffice> getAllByNameAndCityName(String name, String cityName) {
		log.info("Retrieving all post offices by name: {" + name + "} and city name: {" + cityName + "}");
		return repository.getAllByNameAndCityName(name, cityName);
	}

	@Override
	public void deleteById(Integer id) {
		log.info("Deleting post office by id: {" + id + "}");
		repository.deleteById(id);
	}
}
