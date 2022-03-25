package me.mikholskiy.services;

import java.util.List;
import java.util.Optional;

public interface Service<T> {
	Optional<T> get(int id);

	List<T> getAll();

	void save(T t);

	void delete(int id);
}
