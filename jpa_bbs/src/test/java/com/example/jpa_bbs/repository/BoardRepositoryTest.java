package com.example.jpa_bbs.repository;

import java.util.Optional;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.jpa_bbs.entity.Board;
import com.example.jpa_bbs.entity.Member;

@SpringBootTest
public class BoardRepositoryTest {
	
	@Autowired
	private BoardRepository boardRepository;
	
	//@Test
	public void insertBoard() {
		IntStream.rangeClosed(1, 100).forEach(i -> {
			Member member = Member.builder().email("user" + i + "@green.com").build();
			Board board = Board.builder()
					.title("Title...." + i)
					.content("Content...." + i)
					.writer(member)
					.build();
			
			boardRepository.save(board);
		});
	}
	
	@Test
	public void testRead() {
		Optional<Board> result = boardRepository.findById(100L);
		
		Board board = result.get();
		
		System.out.println(board);
		System.out.println(board.getWriter().getEmail());
	}
	
	
	
	
	
	
}
