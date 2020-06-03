package com.example.RestExample.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDAOService {
	//here we are making the use of static arraylist to store the info about user 
	//and we are trying to perform certain operation based on the static arrayList
	private static List<User> users=new ArrayList<>();
	private static int usersCount=3;
	static {
		users.add(new User(1,"Mansi",new Date()));
		users.add(new User(2,"Santhana",new Date()));
		users.add(new User(3,"Tanmay",new Date()));
	}
	
	//return all the users stored in the list
	public List<User> findAll(){
		return users;
	}
	
    //save a user
	public User save(User user) {
		if(user.getId()==null) {
			user.setId(++usersCount);
		}
		users.add(user);
		return user;}
	//return a specific user according to the id
		public User findOne(int id){
			for(User user:users)
			{
				if(user.getId()==id)
				{return user;
				}
			}
			return null;
			}
		
		
	//delete the user by using the id
	//we make use of the iterator to delete the user and iterate through it
		public User deleteById(int id){
			Iterator<User> iterator=users.iterator();
				while(iterator.hasNext())
				{
					User user=iterator.next();
					if(user.getId()==id)
					{	iterator.remove();
						return user;
				    }
				}
			
			return null;
		}
	
}
			
		