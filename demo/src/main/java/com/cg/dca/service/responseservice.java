package com.cg.dca.service;
	import java.util.ArrayList;
import java.util.List;
	import java.util.function.Supplier;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.http.HttpStatus;
	import org.springframework.http.ResponseEntity;
	import org.springframework.stereotype.Service;
	import org.springframework.web.bind.annotation.DeleteMapping;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.PostMapping;
	import org.springframework.web.bind.annotation.PutMapping;
	import org.springframework.web.bind.annotation.RequestBody;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RestController;
	import com.cg.dca.entity.Feed;
import com.cg.dca.entity.Response;
import com.cg.dca.repository.responserepository;
	/*import com.cg.dca.exception.UnknownDeveloperException;
	import com.cg.dca.exception.UnknownFeedException;
	import com.cg.dca.repository.IFeedRepository;*/



	@Service
	public class responseservice {
		
		@Autowired
		responserepository repo;

	public Response addResponse(Response resp)
	
 {
		repo.save(resp);
		return resp; 
	}
		
	public Response editResponse(Response resp) throws Throwable{
		

		int id=resp.getRespId();
		/*Supplier s1= ()->new ResourceNotFoundException("Feed Does not exist in the database");*/
	Response r1=repo.findById(id).orElseThrow();
		r1.setAnswer(r1.getAnswer());
		repo.save(r1);
		return r1;
	}
		public Response deleteResponseById(int respid)
		
		{
			Response r1=repo.getById(respid);
			repo.deleteById(respid);
			return r1;
		}
		public List<Response>getDeveloper(int devId) 
		  {
			Response r= repo.findById(devId).orElseThrow();
			  List<Response> r1= new ArrayList<>(); 
			  r1.add(r);
			  return r1;
		  
		  }
		public List<Response>getFeed(int feedId) 
		  { 
			  List<Response> r1=(List<Response>) repo.findById(feedId).orElseThrow(); 
			  return r1;
		  
		  }
	}
	
