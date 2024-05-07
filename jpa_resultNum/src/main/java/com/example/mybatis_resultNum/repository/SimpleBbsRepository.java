package com.example.mybatis_resultNum.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.mybatis_resultNum.entity.SimpleBbs;

public interface SimpleBbsRepository extends JpaRepository<SimpleBbs, Long>{
	@Query(value="SELECT * FROM tbl_simple_bbs", nativeQuery=true)
	List<SimpleBbs> getNativeResult();
}
