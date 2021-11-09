package com.cg.dca.repository;
	import org.springframework.data.jpa.repository.JpaRepository;
	import org.springframework.stereotype.Repository;

import com.cg.dca.entity.User;

	//import com.model.Developer;

	@Repository
	public interface IUserrepository extends JpaRepository<User,String> {
		User findByUserId(int id);

	}



