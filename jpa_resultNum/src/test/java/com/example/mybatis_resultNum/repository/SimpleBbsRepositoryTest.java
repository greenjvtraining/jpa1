package com.example.mybatis_resultNum.repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.mybatis_resultNum.entity.SimpleBbs;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class SimpleBbsRepositoryTest {
	
	@Autowired
	SimpleBbsRepository rp;
	
	//@Test
	public void testClass() {
		log.info(rp.getClass().getName());
	}
	
	@Test
	public void testSelectAll() {
		//List<SimpleBbs> list = rp.findAll();
		List<SimpleBbs> list = rp.getNativeResult();
		for(SimpleBbs bbs : list) {
			System.out.println(bbs);
		}
		
	}
	
	@Test
	public void testCountBbs() {
		int total = (int) rp.count();
		System.out.println("total : " + total);
	}
	//@Test
	public void testInsertDummies() {
		IntStream.rangeClosed(1, 100).forEach( i -> {
			SimpleBbs simpleBbs = SimpleBbs.builder()
					.writer("user" + i)
					.title("title.." + i)
					.content("content....." + i)
					.build();
			rp.save(simpleBbs);
		});
	}
	
	//@Test
	public void testSelect() {
		Long id = 100L;
		Optional<SimpleBbs> result = rp.findById(id);
		log.info("==========================");
		
		if(result.isPresent()) {
			SimpleBbs simpleBbs = result.get();
			log.info(simpleBbs);
		}
	}
	
	//@Test
	//@Transactional
	public void testSelect2() {
		long id = 100L;
		
		SimpleBbs simpleBbs = rp.getOne(id);
		log.info("==========================");
		log.info(simpleBbs);
	}
	
	//@Test
	public void testUpdate() {
		SimpleBbs simpleBbs = SimpleBbs.builder()
				.id(100L)
				.writer("user100")
				.title("update!!")
				.content("update content....")
				.build();
		
		System.out.println(rp.save(simpleBbs));
	}
	
	//@Test
	public void testDelete() {
		Long id = 100L;
		
		rp.deleteById(id);
	}
	
	
	
}
