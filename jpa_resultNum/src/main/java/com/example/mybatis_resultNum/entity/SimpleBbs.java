package com.example.mybatis_resultNum.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_simpleBbs")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SimpleBbs {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(length = 20, nullable = false)
	private String writer;
	@Column(length = 50, nullable = false)
	private String title;
	@Size(min = 0, max = 100, message="content min 0, max 100")
	private String content;
	
}
