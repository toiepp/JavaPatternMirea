package me.mikholskiy.service;

import me.mikholskiy.daos.PostOfficeDao;
import me.mikholskiy.entities.PostOffice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaQuery;
import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
@Transactional
public class PostOfficeServiceImpl implements Service<PostOffice> {
	private PostOfficeDao postOfficeDao;

	@Autowired
	public void setPostOfficeDao(PostOfficeDao postOfficeDao) {
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
	public List<PostOffice> getAll(CriteriaQuery<PostOffice> criteriaQuery) {
		return postOfficeDao.getAll(criteriaQuery);
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
