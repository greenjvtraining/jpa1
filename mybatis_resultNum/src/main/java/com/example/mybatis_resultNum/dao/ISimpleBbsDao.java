package com.example.mybatis_resultNum.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.mybatis_resultNum.dto.SimpleBbsDto;

@Mapper
public interface ISimpleBbsDao {
	
	public List<SimpleBbsDto> listDao();
	public SimpleBbsDto viewDao(@Param("id") String id);
	public int countBbs();
	public int writeDao(String writer, String title, String content);
	public int writeDao2(@Param("dto") SimpleBbsDto dto);
	public int deleteDao(@Param("id") String id);
}
