package com.example.simpleBbs_jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.simpleBbs_jpa.entity.Board;

public interface BoardRepository extends JpaRepository<Board, Long>{

}
