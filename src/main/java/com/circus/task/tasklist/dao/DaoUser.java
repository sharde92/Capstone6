package com.circus.task.tasklist.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class DaoUser {
	@PersistenceContext
	
	@Autowired
	EntityManager entityManager;

}
