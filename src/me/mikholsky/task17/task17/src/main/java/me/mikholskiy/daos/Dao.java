package me.mikholskiy.daos;

import java.util.List;
import java.util.Optional;

public interface Dao<T> {
	Optional<T> get(int id);

	List<T> getAll();

	void save(T t);

	void delete(int id);
}
