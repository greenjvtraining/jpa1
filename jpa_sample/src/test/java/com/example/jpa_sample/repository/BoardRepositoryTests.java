package com.example.jpa_sample.repository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.example.jpa_sample.entity.Member;
import com.example.jpa_sample.entity.Tboard;

import jakarta.transaction.Transactional;

@SpringBootTest
public class BoardRepositoryTests {

	@Autowired
	private TboardRepository boardRepository;
	
	//@Test
	public void insertBoard() {
		IntStream.rangeClosed(1, 100).forEach(i -> {
			Member member = Member.builder().email("user" + i + "@aaa.com").build();
			
			Tboard board = Tboard.builder()
					.title("Title...." + i)
					.content("Content....." + i)
					.writer(member)
					.build();
			
			boardRepository.save(board);
		});
	}
	
	//@Test
	@Transactional
	public void testRead1() {
		Optional<Tboard> result = boardRepository.findById(100L);
		
		Tboard board = result.get();
		
		System.out.println(board);
		System.out.println(board.getWriter());
	}
	
	//@Test
	public void testReadWrithWriter() {
		Object result = boardRepository.getBoardWithWriter(100L);
		
		Object[] arr = (Object[])result;
		
		System.out.println("-------------------------------------");
		System.out.println(Arrays.toString(arr));
	}

	//@Test
	public void testGetBoardWithReply() {
		List<Object[]> result = boardRepository.getBoardWithReply(100L);
		
		for(Object[] arr : result) {
			System.out.println(Arrays.toString(arr));
		}
	}
	
	//@Test
	public void testWithReplyCount() {
		Pageable pageable = PageRequest.of(0, 10, Sort.by("bno").descending());
		Page<Object[]> result = boardRepository.getBoardwithReplyCount(pageable);
		
		result.get().forEach(row -> {
			Object[] arr = (Object[])row;
			
			System.out.println(Arrays.toString(arr));
		});
	}
	
	@Test
	public void testRead3() {
		Object result = boardRepository.getBoardByBno(100L);
		
		Object[] arr = (Object[])result;
		
		System.out.println(Arrays.toString(arr));
	}
	
	
	
	
	
	
}
