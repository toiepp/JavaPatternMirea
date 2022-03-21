package me.mikholskiy.service;

import me.mikholskiy.daos.Dao;
import me.mikholskiy.entities.PostOffice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
@Transactional
public class PostOfficeServiceImpl implements Service<PostOffice> {
	private Dao<PostOffice> postOfficeDao;

	@Autowired
	public void setPostOfficeDao(Dao<PostOffice> postOfficeDao) {
		this.postOfficeDao = postOfficeDao;
	}

	@Override
	public Optional<PostOffice> get(int id) {
		return postOfficeDao.get(id);
	}

	@Override
	public List<PostOffice> getAll() {
		return postOfficeDao.getAll();
	}

	@Override
	public void save(PostOffice postOffice) {
		postOfficeDao.save(postOffice);
	}

	@Override
	public void delete(int id) {
		postOfficeDao.delete(id);
	}
}
