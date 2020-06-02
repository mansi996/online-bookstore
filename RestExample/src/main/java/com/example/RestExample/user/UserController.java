//we make this controller class to actually make use of the dao class methods and 

//call it here to show the result in the browser using the different kind of mapping
//for get mapping- it is used to show or fetch the result so we are implementation
//retrieveAllUser and retrieveUserById

//POST MAPPING - It is used to create something so we will add some user using the post 




package com.example.RestExample.user;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	//we make the use of DAO layer 
	@Autowired
	private UserDAOService service;

	//retrieveAllUsers
	
	@GetMapping("/users")
	public List<User> retrieveAllUsers(){
			return service.findAll();
			
	}
	
	//retrieveUserById
	
	@GetMapping("/users/{id}")
	public User retrieveUserById(@PathVariable int id)
	{
		User user=service.findOne(id);
			if(user==null)
				throw new userNotFoundException("id-"+id);
				return user;
	}
	
	//POST MAPPING- TO CREATE USER AND SAVE IT
	//input- take details bout user he/she want to save 
	//output- CREATED AND return the details 
	
	@PostMapping("/users")
	public void createUser(@RequestBody User user)
	{
		User saveUser=service.save(user);
	}

	//i will create the delte resource here
	
	@DeleteMapping("/users/{id}")
	public User deleteUser(@PathVariable int id)
	{
		User user=service.deleteById(id);
			if(user==null)
				throw new userNotFoundException("id-"+id);
			return user;
	}
	
	
	
	
}
