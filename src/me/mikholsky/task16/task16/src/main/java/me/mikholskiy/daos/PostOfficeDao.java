package me.mikholskiy.daos;

import me.mikholskiy.entities.PostOffice;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository("postOfficeDao")
public class PostOfficeDao implements Dao<PostOffice> {
	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional
	public Optional<PostOffice> get(int id) {
		return Optional.ofNullable(sessionFactory.getCurrentSession().get(PostOffice.class, id));
	}

	@Override
	@Transactional
	public List<PostOffice> getAll() {
		return sessionFactory.getCurrentSession()
							 .createQuery("from PostOffice", PostOffice.class)
							 .list();
	}

	@Override
	@Transactional
	public void save(PostOffice postOffice) {
		sessionFactory.getCurrentSession().save(postOffice);
	}

	@Override
	@Transactional
	public void delete(int id) {
		Session session = sessionFactory.getCurrentSession();
		PostOffice postOffice = session.get(PostOffice.class, id);

		session.delete(postOffice);
	}
}
