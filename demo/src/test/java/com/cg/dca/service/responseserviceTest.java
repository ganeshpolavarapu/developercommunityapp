package com.cg.dca.service;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.cg.dca.entity.Developer;
import com.cg.dca.entity.Feed;
import com.cg.dca.entity.Response;
import com.cg.dca.repository.responserepository;

@SpringBootTest
class IReposnseServiceTest {
	@Autowired
	responseservice responseservice;
	@MockBean
	responserepository repo;
	@Test
	void testAddResponse() {
		Response r=new Response();
		r.setRespId(1);
		r.setRespTime(null);
		r.setRespDate(null);
		r.setAnswer(null);
		r.setAccuracy(0);
		Developer d=new Developer();
		Feed f=new Feed();
		r.setDev(d);
		r.setFeed(f);
		Mockito.when(repo.save(r)).thenReturn(r);
	}

	@Test
	void testEditResponse() throws Throwable {
		Response r=new Response();
		r.setRespId(1);
		r.setRespTime(null);
		r.setRespDate(null);
		r.setAnswer(null);
		r.setAccuracy(3);
		Developer d=new Developer();
		Feed f=new Feed();
		r.setDev(d);
		r.setFeed(f);
		Optional<Response>c2=Optional.of(r);
		Mockito.when(repo.findById(1)).thenReturn(c2);
		Mockito.when(repo.save(r)).thenReturn(r);
		r.setAccuracy(2);
		r.setAnswer("hii");
		assertThat(responseservice.editResponse(r)).isEqualTo(r);
		
	
		
	}

	@Test
	void testDeleteResponseById() {
		Response r=new Response();
		r.setRespId(1);
		r.setRespTime(null);
		r.setRespDate(null);
		r.setAnswer(null);
		r.setAccuracy(3);
		Developer d=new Developer();
		Feed f=new Feed();
		r.setDev(d);
		r.setFeed(f);
		Optional<Response>c2=Optional.of(r);
		Mockito.when(repo.findById(1)).thenReturn(c2);
		Mockito.when(repo.existsById(r.getRespId())).thenReturn(false);
		r.setAccuracy(2);
		r.setAnswer("hii");
		assertFalse(repo.existsById(r.getRespId()));
		
	
		
	}

	@Test
	void testGetDeveloper() {
		Response r=new Response();
		r.setRespId(1);
		r.setRespTime(null);
		r.setRespDate(null);
		r.setAnswer(null);
		r.setAccuracy(3);
		Developer d=new Developer();
		Feed f=new Feed();
		r.setDev(d);
		r.setFeed(f);
		List<Response>r2=new ArrayList<>();
		r2.add(r);
		int id=d.getDevId();
		Optional<Response> c2=Optional.of(r);
		Mockito.when(repo.findById(id)).thenReturn(c2);
		
		//assertThat(developerservice.getDeveloper(1)).isEqualTo(d1);
		Mockito.when(repo.saveAll(r2)).thenReturn(r2);
		assertThat(responseservice.getDeveloper(id)).isEqualTo(r2);
		
		
	}

	@Test
	void testGetFeed() {
		Response r=new Response();
		r.setRespId(1);
		r.setRespTime(null);
		r.setRespDate(null);
		r.setAnswer(null);
		r.setAccuracy(3);
		Developer d=new Developer();
		Feed f=new Feed();
		r.setDev(d);
		r.setFeed(f);
		List<Response>r2=new ArrayList<>();
		r2.add(r);
		int id=f.getFeedId();
		Optional<Response> c2=Optional.of(r);
		Mockito.when(repo.findById(id)).thenReturn(c2);
		
		//assertThat(developerservice.getDeveloper(1)).isEqualTo(d1);
		Mockito.when(repo.saveAll(r2)).thenReturn(r2);
		assertThat(responseservice.getDeveloper(id)).isEqualTo(r2);
		
	}

}
