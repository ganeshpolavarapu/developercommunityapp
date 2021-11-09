package com.cg.dca.controller;
	import java.util.List;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.http.HttpStatus;
	import org.springframework.http.ResponseEntity;
	import org.springframework.web.bind.annotation.DeleteMapping;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.PostMapping;
	import org.springframework.web.bind.annotation.RequestBody;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RestController;
import com.cg.dca.entity.Feed;
import com.cg.dca.exception.UnknownFeedException;
import com.cg.dca.service.IFeedservice;
	@RestController
	@RequestMapping(path="/api")

	public class Feedcontroller {
		@Autowired
		IFeedservice feedservice;
	@PostMapping("/addFeed")	
	public ResponseEntity<Feed>addFeed(@RequestBody Feed feed)
	{
	  Feed feed1=feedservice.addFeed(feed);
	  ResponseEntity re=new ResponseEntity<Feed>(feed1,HttpStatus.OK);
	  
	return re;
	}
	@PostMapping("/editFeed")
	public ResponseEntity<Feed>editFeed()
	{
		Feed feed1=(Feed) feedservice.editFeed();
		ResponseEntity re=new ResponseEntity<Feed>(HttpStatus.OK);
		return re;
		
	}

	@PostMapping("/getFeedsBykeyword") 
	public ResponseEntity<List<Feed>>getFeedsBykeyword(String keyword) 
	{ 
		List<Feed>lfeed1=feedservice.getFeedsByKeyword(keyword);
	  ResponseEntity re=new ResponseEntity<List<Feed>>(lfeed1,HttpStatus.OK);
	  return re;
	  
	  }
	  @PostMapping("/likefeed") 
	  public ResponseEntity<List<Feed>> likeFeed(int respId) throws UnknownFeedException { 
		  int id=respId;
	  Feed lfeed1=feedservice.likeFeed(id);
	  ResponseEntity re=new ResponseEntity(lfeed1,HttpStatus.OK);
	  return re;
	  
	  }
	  @PostMapping("/getFeedsByTopic") public
	  ResponseEntity<List<Feed>>getFeedsByTopic(String topic) { 
		  String top=topic;
	  List<Feed>lfeed1=feedservice.getFeedsByTopic(top); ResponseEntity re=new
	  ResponseEntity<List<Feed>>(lfeed1,HttpStatus.OK); return re; }
	  
	 	
	}





