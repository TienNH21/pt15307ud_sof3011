package com.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import com.entity.User;
import com.utils.HibernateUtils;

public class UserDAO {
	private Session hSession;
	
	public UserDAO()
	{
		this.hSession = HibernateUtils.getSession();
	}
	
	public User store(User entity)
	{
		this.hSession.beginTransaction();
		Integer id = (Integer) this.hSession.save(entity);
		this.hSession.getTransaction().commit();

		entity.setId(id);
		return entity;
	}

	public List<User> paginate(int offset, int limit)
	{
		String hql = "FROM User";
		Query query = this.hSession.createQuery(hql);
		query.setFirstResult(offset);
		query.setMaxResults(offset + limit);
		
		List<User> listUser = query.getResultList();
		
		return listUser;
	}
	
	public User findById(int id)
	{
		User entity = this.hSession.get(User.class, id);

		return entity;
	}
}
