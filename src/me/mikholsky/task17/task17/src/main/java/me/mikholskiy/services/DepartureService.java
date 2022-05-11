package me.mikholskiy.services;

import me.mikholskiy.daos.Dao;
import me.mikholskiy.entities.Departure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
@Transactional
public class DepartureService implements Service<Departure> {
	private Dao<Departure> departureDao;

	@Autowired
	public void setDepartureDao(Dao<Departure> departureDao) {
		this.departureDao = departureDao;
	}

	@Override
	public Optional<Departure> get(int id) {
		return departureDao.get(id);
	}

	@Override
	public List<Departure> getAll() {
		return departureDao.getAll();
	}

	@Override
	public List<Departure> getAllFiltered(CriteriaQuery<Departure> query) {
		return departureDao.getAllFiltered(query);
	}

	@Override
	public void save(Departure departure) {
		departureDao.save(departure);
	}

	@Override
	public void delete(int id) {
		departureDao.delete(id);
	}
}
