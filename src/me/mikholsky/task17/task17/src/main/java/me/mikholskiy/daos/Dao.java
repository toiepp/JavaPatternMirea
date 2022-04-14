package me.mikholskiy.daos;

import javax.persistence.criteria.CriteriaQuery;
import java.util.List;
import java.util.Optional;

public interface Dao<T> {
	Optional<T> get(int id);

	List<T> getAll();

	List<T> getAll(CriteriaQuery<T> criteriaQuery);

	void save(T t);

	void delete(int id);
}
