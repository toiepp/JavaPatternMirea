package me.mikholskiy.task18.services.departure;

import me.mikholskiy.task18.domains.Departure;
import me.mikholskiy.task18.repositories.DepartureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service("departureService")
public class DepartureServiceSimpleImpl implements DepartureService {
	private DepartureRepository departureRepository;

	@Override
	public void save(Departure departure) {
		departureRepository.save(departure);
	}

	@Autowired
	public void setDepartureRepository(DepartureRepository departureRepository) {
		this.departureRepository = departureRepository;
	}

	@Override
	public Optional<Departure> getById(Integer id) {
		return Optional.of(departureRepository.getById(id));
	}

	@Override
	public Optional<Departure> getByType(String type) {
		return departureRepository.getByType(type);
	}

	@Override
	public Optional<Departure> getByDate(String date) {
		return departureRepository.getByDate(date);
	}

	@Override
	public Collection<Departure> getAll() {
		return departureRepository.findAll();
	}

	@Override
	public Collection<Departure> getAllByType(String type) {
		return departureRepository.getAllByType(type);
	}

	@Override
	public Collection<Departure> getAllByDate(String date) {
		return departureRepository.getAllByDate(date);
	}

	@Override
	public void deleteById(Integer id) {
		departureRepository.deleteById(id);
	}
}
