package com.cg.dca.service;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;

import com.cg.dca.entity.User;
import com.cg.dca.exception.UserNotFoundException;
import com.cg.dca.repository.IUserrepository;
	@Service
	public class IUserservice {
		 @Autowired 
		  IUserrepository repo;
		 public User login(User users) throws UserNotFoundException
		 {
			int id=users.getUserId();
			User c=repo.findByUserId(id);
			String x=Integer.toString(id);
			if (c == null) {
	            throw new UserNotFoundException(x);
	        }
	 
			return users;
			 
		 }
		 public User logOut(User users)
		 {
			return users;		 
		 }

	}



