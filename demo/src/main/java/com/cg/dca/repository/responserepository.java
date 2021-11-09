package com.cg.dca.repository;
	import java.util.List;
	import org.springframework.data.jpa.repository.JpaRepository;
	import org.springframework.data.jpa.repository.Query;
	//import org.springframework.data.repository.query.Param;
	import org.springframework.stereotype.Repository;

import com.cg.dca.entity.Response;
	@Repository
	public interface responserepository extends JpaRepository<Response,Integer>{
		//Developer findByCname(String cname);	
		/*
		 * @Query("update Developer d set d.read=:isRead where d.id=:dev.id") Developer
		 * updateDeveloper(@Param("id") Developer dev);
		 */
		 
		 
		/*@Query("Select d from Developer d where d.devId=:devid")
		Developer fectchDeveloper(int devid);
	 	@Query("Select d from Developer d ")
		List<Developer> fetchAllDevelopers();*/
	}
