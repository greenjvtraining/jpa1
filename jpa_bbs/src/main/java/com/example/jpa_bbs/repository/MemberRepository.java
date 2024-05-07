package com.example.jpa_bbs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jpa_bbs.entity.Member;

public interface MemberRepository extends JpaRepository<Member, String>{

}
