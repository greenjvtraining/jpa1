package com.example.jpa_sample.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class Treply {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long rno;
	private String text;
	private String replyer;
	
	@ManyToOne
	@ToString.Exclude
	private Tboard board; //연관관계 지정
}
