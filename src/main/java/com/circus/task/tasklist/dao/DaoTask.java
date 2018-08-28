package com.circus.task.tasklist.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.circus.task.tasklist.model.Task;



@Repository
@Transactional
public class DaoTask {
	
	@PersistenceContext
	
	@Autowired
	EntityManager em;
	
	public List<Task> findAll() {
		// The SELECT clause is optional in HQL. If omitted, it's basically SELECT *.
		// When creating a a query specify the type of the results: Task.class
		return em.createQuery("FROM Task", Task.class).getResultList();
	}
	
	public Task findById(Long id) {
		return em.find(Task.class, id);
	}
	public void create(Task task) {
		em.persist(task);
	}
	
	public void update(Task task) {
		em.merge(task);
	}
	
	public void delete(Long id) {
		// Deleting with Hibernate entity manager requires fetching a reference first.
		Task task = em.getReference(Task.class, id);
		em.remove(task);
	}
}
