//this class helps us to save user and retrieve from the database-called as repository
//so in JPA we make use of the Entity manager 

package com.example.Jpa_01.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.Jpa_01.entity.User;

@Repository
@Transactional
public class UserDAOService {

	@PersistenceContext
	//we create an instance of entity manager 
	public EntityManager entityManager;
	
	//a save method 
	//it is used to save the dao to the database 
	
	public long insert(User user)
	{	//open transaction
		entityManager.persist(user);
		//close transaction
		return user.getId();
	}
}