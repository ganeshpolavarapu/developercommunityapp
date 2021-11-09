package com.cg.dca.repository;
	import java.util.List;
	  import org.springframework.data.jpa.repository.JpaRepository;
	  import org.springframework.data.jpa.repository.Query;
	  import org.springframework.stereotype.Repository;

import com.cg.dca.entity.Feed;
	  @Repository
	  public interface IFeedrepository extends JpaRepository<Feed,Integer>{

		List<Feed> findByTopic(String topic);

		List<Feed> findByKeyword(String keyword);

		//List<Feeds> search(String keyword);
	  	
}



