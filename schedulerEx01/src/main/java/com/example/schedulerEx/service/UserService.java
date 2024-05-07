package com.example.schedulerEx.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.schedulerEx.dto.User;

@Service
public class UserService {

	private List<User> users = new ArrayList<>();
	
	public void addUser(User user) {
		users.add(user);
	}
	
	public String notifyInactiveUsers() {
		String msg = null;
		LocalDateTime now = LocalDateTime.now();
		for(User user : users) {
			if(user.getLastActivityTime().plusMinutes(1).isBefore(now)) {
				msg = sendNotification(user);
			}
			System.out.println("user : " + user);
			System.out.println("InactiveUser msg: " + msg);
		}
		return msg;
	}

	private String sendNotification(User user) {
		String notificationMessage = user.getUsername() + "님, 로그아웃하세요...1분이상 아무것도 안했잖아요.";
		System.out.println(user.getUsername() + "님에게 비활성 알림을 보냅니다.");
		return notificationMessage;
	}
}
