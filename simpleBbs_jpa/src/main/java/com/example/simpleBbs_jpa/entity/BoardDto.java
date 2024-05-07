package com.example.simpleBbs_jpa.entity;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoardDto {
	private Long bno;
	private String title;
	private String content;
	private String writer;
}
