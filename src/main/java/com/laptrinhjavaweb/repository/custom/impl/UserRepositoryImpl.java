package com.laptrinhjavaweb.repository.custom.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.laptrinhjavaweb.entity.UserEntity;
import com.laptrinhjavaweb.repository.custom.UserRepositoryCustom;
@Repository
public class UserRepositoryImpl extends CommonRepository implements UserRepositoryCustom{

	@PersistenceContext
	private EntityManager entityManager;
	@Override
	public UserEntity findInforUser(long id) {
		StringBuilder sql=this.createSQLfindInfor();
		Query query=entityManager.createNativeQuery(sql.toString(),UserEntity.class);
		return (UserEntity)query.getSingleResult();
	}

}
