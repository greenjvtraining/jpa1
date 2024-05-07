package com.example.jpa_bbs.repository;

import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.jpa_bbs.entity.Member;

@SpringBootTest
public class MemberRepositoryTest {
	
	@Autowired
	private MemberRepository memberRepository;
	
	@Test
	public void insertMembers() {
		IntStream.rangeClosed(1, 100).forEach(i -> {
			Member member = Member.builder()
					.email("user" + i + "@green.com")
					.password("1111")
					.name("USER" + i)
					.build();
			memberRepository.save(member);
		});
	}
}
