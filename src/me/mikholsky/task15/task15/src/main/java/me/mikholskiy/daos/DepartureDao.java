package me.mikholskiy.daos;

import me.mikholskiy.entities.Departure;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository("departureDao")
public class DepartureDao implements Dao<Departure> {
	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional
	public Optional<Departure> get(int id) {
		return Optional.ofNullable(sessionFactory.getCurrentSession().get(Departure.class, id));
	}

	@Override
	@Transactional
	public List<Departure> getAll() {
		return sessionFactory.getCurrentSession()
							 .createQuery("from Departure", Departure.class)
							 .list();
	}

	@Override
	@Transactional
	public void save(Departure departure) {
		sessionFactory.getCurrentSession().save(departure);
	}

	@Override
	@Transactional
	public void delete(int id) {
		Session session = sessionFactory.getCurrentSession();
		Departure departure = session.get(Departure.class, id);

		session.delete(departure);
	}
}
