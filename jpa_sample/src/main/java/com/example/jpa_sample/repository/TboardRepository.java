package com.example.jpa_sample.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.jpa_sample.entity.Tboard;

public interface TboardRepository extends JpaRepository<Tboard, Long>{

	@Query("select b, w from Tboard b left join b.writer w where b.bno = :bno")
	Object getBoardWithWriter(@Param("bno") Long bno);
	
	@Query("select b, r from Tboard b left join Treply r on r.board = b where b.bno = :bno")
	List<Object[]> getBoardWithReply(@Param("bno") Long bno);
	
	@Query(value = "SELECT b, w, count(r) " + 
			" FROM Tboard b " +
			" LEFT JOIN b.writer w " + 
			" LEFT JOIN Treply r ON r.board = b " + 
			" GROUP BY b",
			countQuery = "SELECT COUNT(b) FROM Tboard b")
	Page<Object[]> getBoardwithReplyCount(Pageable pageable);
	
	@Query("SELECT b, w, count(r) " + 
			" FROM Tboard b LEFT JOIN b.writer w " +
			" LEFT JOIN Treply r ON r.board = b" +
			" WHERE b.bno = :bno")
	Object getBoardByBno(@Param("bno") Long bno);
	
	
	
}
