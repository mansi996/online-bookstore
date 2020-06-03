//we make this controller class to actually make use of the dao class methods and 

//call it here to show the result in the browser using the different kind of mapping
//for get mapping- it is used to show or fetch the result so we are implementation
//retrieveAllUser and retrieveUserById

//POST MAPPING - It is used to create something so we will add some user using the post 


package com.example.RestExample.user;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserJpaController {
	
	//we make the use of DAO layer 
	
	
	//we make use of the Jpa repository
	@Autowired 
	private UserRepository userRepository;

	//retrieveAllUsers
	
	@GetMapping("/jpa/users")
	public List<User> retrieveAllUsers(){
			return userRepository.findAll();
			
	}
	
	//retrieveUserById
	
	
	  @GetMapping("/jpa/users/{id}")
	  public Optional<User> retrieveUserById(@PathVariable int id) {
		  Optional<User> user=userRepository.findById(id); 
		  if(!user.isPresent())
			  throw new userNotFoundException("id-"+id);
		  return user;
	  }
	
	//	Resource<User> resource=new Resource<User>(user.get());
	//}
	
	
	//POST MAPPING- TO CREATE USER AND SAVE IT
	//input- take details bout user he/she want to save 
	//output- CREATED AND return the details 
	
	@PostMapping("/jpa/users")
	public void createUser(@RequestBody User user)
	{
		User saveUser=userRepository.save(user);
	}

	//i will create the delete resource here
	
	@DeleteMapping("/jpa/users/{id}")
	public User deleteUser(@PathVariable int id)
	{
		userRepository.deleteById(id);
		System.out.println("Deleted");
		return null; 
	}
	
	
	
	
}
