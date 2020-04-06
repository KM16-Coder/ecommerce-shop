package com.laptrinhjavaweb.repository.custom.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.laptrinhjavaweb.entity.RoleEntity;
import com.laptrinhjavaweb.repository.custom.RoleRepositoryCustom;

@Repository
public class RoleRepositoryImpl extends CommonRepository implements RoleRepositoryCustom{
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public RoleEntity findRoleOfUser(long userId) {
		StringBuilder sql=this.createSQLRole();
		sql.append("WHERE us.userrole_id = :userrole_id");
		Query query=entityManager.createNativeQuery(sql.toString(),RoleEntity.class);
		query.setParameter("userrole_id", userId);
		return (RoleEntity)query.getSingleResult();
	}
}
