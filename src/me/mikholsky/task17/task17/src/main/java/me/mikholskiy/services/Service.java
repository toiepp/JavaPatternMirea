package me.mikholskiy.services;

import javax.persistence.criteria.CriteriaQuery;
import java.util.List;
import java.util.Optional;

public interface Service<T> {
	Optional<T> get(int id);

	List<T> getAll();

	List<T> getAllFiltered(CriteriaQuery<T> query);

	void save(T t);

	void delete(int id);

}
