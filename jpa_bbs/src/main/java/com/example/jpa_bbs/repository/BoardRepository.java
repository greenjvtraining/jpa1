package com.example.jpa_bbs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jpa_bbs.entity.Board;

public interface BoardRepository extends JpaRepository<Board, Long>{

}
