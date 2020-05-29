package com.example.Jpa_01;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.Jpa_01.entity.User;
import com.example.Jpa_01.service.UserRepository;

@Component
public class UserRepositoryCommandLineRunner implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	private static final Logger log=
			LoggerFactory.getLogger(UserRepositoryCommandLineRunner.class);
	
	@Override
	public void run(String... arg0) throws Exception
	{
		User user=new User("hello","Admin");
		User user1=new User("welcome","mad World");
		userRepository.save(user);
		userRepository.save(user1);
		log.info("USER IS CREATED SUCCESSFULY"+user);
		log.info("USER IS CREATED SUCCESSFULY"+user1);

	}
}
 