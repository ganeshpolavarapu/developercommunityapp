package com.cg.dca.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.dca.entity.Response;
import com.cg.dca.service.responseservice;
@RestController
@RequestMapping(path="/cg")

public class Responsecontroller {
		@Autowired
		responseservice responseservice;
		public String HelloIFeed()
		{
			String msg="Welcome to Spring Data Jpa";
			return msg;
		}
	@PostMapping("/addResponse")	
	public ResponseEntity<Response>addResponse(@RequestBody Response r1)
	{
	  Response feed1=responseservice.addResponse(r1);
	  ResponseEntity re=new
	  ResponseEntity<Response>(feed1,HttpStatus.OK);
	  
	return re;
	}
	@PutMapping("/editresponse")
	public ResponseEntity<Response>editResponse(@RequestBody Response r1) throws Throwable
	{
		Response r2=(Response) responseservice.editResponse(r1);
		ResponseEntity re=new
				ResponseEntity<Response>(r2,HttpStatus.OK);
		return re;
		
	}
	@DeleteMapping("/Deleteresponse")
	public ResponseEntity<Response>DeleteResponse(@RequestBody int respid) 
	{
		Response r2=(Response) responseservice.deleteResponseById(respid);
		ResponseEntity re=new
				ResponseEntity<Response>(r2,HttpStatus.OK);
		return re;
		
	}
	@GetMapping("/GetFeed")
	public ResponseEntity<Response>GetFeed(@RequestBody int feedid) 
	{
		Response r2=(Response) responseservice.getFeed(feedid);
		ResponseEntity re=new
				ResponseEntity<Response>(r2,HttpStatus.OK);
		return re;
		
	}
	@GetMapping("/GetDeveloper")
	public ResponseEntity<Response>GetDeveloper(@RequestBody int devid) 
	{
		Response r2=(Response) responseservice.getDeveloper(devid);
		ResponseEntity re=new
				ResponseEntity<Response>(r2,HttpStatus.OK);
		return re;
		
	}
	


	/*
	 * @GetMapping("/getFeedsBykeyword") public
	 * ResponseEntity<List<Feed>>getFeedsBykeyword(String Keyword) { String Keyword1
	 * = null; List<Feed>lfeed1=feedservice.getFeedsByKeyword(Keyword1);
	 * ResponseEntity re=new ResponseEntity<List<Feed>>(lfeed1,HttpStatus.OK);
	 * return re;
	 * 
	 * }
	 */
	/*
	 * @GetMapping("/getFeedsByTopic") public
	 * ResponseEntity<List<Feed>>getFeedsByTopic(String topic) { String Topic1=null;
	 * List<Feed>lfeed1=feedservice.getFeedsByTopic(Topic1); ResponseEntity re=new
	 * ResponseEntity<List<Feed>>(lfeed1,HttpStatus.OK); return re; }
	 * 
	 */	
	}


