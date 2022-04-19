package me.mikholskiy.task18.services.postOffice;

import me.mikholskiy.task18.domains.PostOffice;
import me.mikholskiy.task18.repositories.PostOfficeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service("postOfficeService")
public class PostOfficeServiceSimpleImpl implements PostOfficeService {
	private PostOfficeRepository repository;

	@Autowired
	public void setRepository(PostOfficeRepository repository) {
		this.repository = repository;
	}

	@Override
	public void save(PostOffice departure) {
		repository.save(departure);
	}

	@Override
	public Optional<PostOffice> getByName(String name) {
		return repository.getByName(name);
	}

	@Override
	public Optional<PostOffice> getByCityName(String cityName) {
		return repository.getByName(cityName);
	}

	@Override
	public Optional<PostOffice> getByNameAndCityName(String name, String cityName) {
		return repository.getByNameAndCityName(name, cityName);
	}

	@Override
	public Collection<PostOffice> getAllByName(String name) {
		return repository.getAllByName(name);
	}

	@Override
	public Collection<PostOffice> getAllByCityName(String cityName) {
		return repository.getAllByCityName(cityName);
	}

	@Override
	public Collection<PostOffice> getAllByNameAndCityName(String name, String cityName) {
		return repository.getAllByNameAndCityName(name, cityName);
	}

	@Override
	public void deleteById(Integer id) {
		repository.deleteById(id);
	}
}
