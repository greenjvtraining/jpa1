package com.example.jpa_sample.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TboardDto {
	private Long bno;
	private String title;
	private String content;
	private String writerEmail;
	private String writerName;
	private LocalDateTime regDate;
	private LocalDateTime modDate;
	private int replyCount;
}
