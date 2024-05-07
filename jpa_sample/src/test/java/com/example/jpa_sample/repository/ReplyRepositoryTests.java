package com.example.jpa_sample.repository;

import java.util.Optional;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.jpa_sample.entity.Tboard;
import com.example.jpa_sample.entity.Treply;

@SpringBootTest
public class ReplyRepositoryTests {

	@Autowired
	private TreplyRepository replyRepository;
	
	//@Test
	public void insertReply() {
		IntStream.rangeClosed(1, 300).forEach(i -> {
			long bno = (long)(Math.random() * 100) + 1;
			
			Tboard board = Tboard.builder().bno(bno).build();
			
			Treply reply = Treply.builder()
					.text("Reply....." + i)
					.board(board)
					.replyer("guest")
					.build();
			
			replyRepository.save(reply);
		});
	}
	
	@Test
	public void readReply1() {
		Optional<Treply> result = replyRepository.findById(1L);
		
		Treply reply = result.get();
		
		System.out.println(reply);
		System.out.println(reply.getBoard().getBno());
	}
	
	
	
}
