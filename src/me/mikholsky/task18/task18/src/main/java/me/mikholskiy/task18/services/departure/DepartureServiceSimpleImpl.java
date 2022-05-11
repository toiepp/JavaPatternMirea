package me.mikholskiy.task18.services.departure;

import me.mikholskiy.task18.domains.Departure;
import me.mikholskiy.task18.repositories.DepartureRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service("departureService")
public class DepartureServiceSimpleImpl implements DepartureService {
	private DepartureRepository departureRepository;
	private static final Logger log = LoggerFactory.getLogger(DepartureServiceSimpleImpl.class);

	@Autowired
	public void setDepartureRepository(DepartureRepository departureRepository) {
		this.departureRepository = departureRepository;
	}

	@Override
	public void save(Departure departure) {
		log.info("Departure {" + departure + "} saved");
		departureRepository.save(departure);
	}

	@Override
	public Optional<Departure> getById(Integer id) {
		log.info("Retrieving departure by id: {" + id + "}");
		return Optional.of(departureRepository.getById(id));
	}

	@Override
	public Optional<Departure> getByType(String type) {
		log.info("Retrieving departure by type: {" + type + "}");
		return departureRepository.getByType(type);
	}

	@Override
	public Optional<Departure> getByDate(String date) {
		log.info("Retrieving departure by date: {" + date + "}");
		return departureRepository.getByDate(date);
	}

	@Override
	public Collection<Departure> getAll() {
		log.info("Retrieving all departures");
		return departureRepository.findAll();
	}

	@Override
	public Collection<Departure> getAllByType(String type) {
		log.info("Retrieving all departures by type: {" + type + "}");
		return departureRepository.getAllByType(type);
	}

	@Override
	public Collection<Departure> getAllByDate(String date) {
		log.info("Retrieving all departures by date: {" + date + "}");
		return departureRepository.getAllByDate(date);
	}

	@Override
	public void deleteById(Integer id) {
		log.info("Deleting departures by id: {" + id + "}");
		departureRepository.deleteById(id);
	}
}
