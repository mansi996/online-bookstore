//we are making this UsrRepository as for every other entity(like persist,merge or remove)
//I have to create new class for different entities 
//I will have to make a full new entity class with silimar logic again and again 
//and then use it and run using the command line runner.

//to avoid suh boiler plate code in my progra i simply extends to JPArepository section 
//which extends JPA repository and will allow to perform all the operations 
//without making a seperate entity class








package com.example.Jpa_01.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Jpa_01.entity.User;

public interface UserRepository extends JpaRepository<User,Long>
{

}
