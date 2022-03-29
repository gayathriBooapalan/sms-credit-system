package com.demo.SMS.service;

import com.demo.SMS.model.User;

public interface UserService {
	User createUser(User user);

	User getCreditFlag(Integer phonenumber);
	

}
