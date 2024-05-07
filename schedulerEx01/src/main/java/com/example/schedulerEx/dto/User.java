package com.example.schedulerEx.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class User {
	private String username;
	private LocalDateTime lastActivityTime;
}
