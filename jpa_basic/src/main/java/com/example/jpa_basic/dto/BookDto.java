package com.example.jpa_basic.dto;

import lombok.Data;

@Data
public class BookDto {
	private Long bno;
	private String title;
	private String author;
	private String publisher;
	private int price;
	private String info;
}
