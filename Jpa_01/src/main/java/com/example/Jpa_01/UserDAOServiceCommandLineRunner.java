package com.example.Jpa_01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.Jpa_01.entity.User;
import com.example.Jpa_01.service.UserDAOService;

@Component
public class UserDAOServiceCommandLineRunner implements CommandLineRunner {

	@Autowired
	private UserDAOService userDAOService;
	
	private static final Logger log=
			LoggerFactory.getLogger(UserDAOServiceCommandLineRunner.class);
	@Override
	public void run(String... arg0) throws Exception
	{
		User user=new User("Mansi","Admin");
		User user1=new User("Tanmay","Kutta");
		long insert=userDAOService.insert(user);
		long insert1=userDAOService.insert(user1);
		log.info("USER IS CREATED SUCCESSFULY"+user);
		log.info("USER IS CREATED SUCCESSFULY"+user1);

	}
}
 