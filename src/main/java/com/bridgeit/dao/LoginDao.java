package com.bridgeit.dao;

import org.springframework.stereotype.Component;

import com.bridgeit.model.User;


public interface LoginDao {
	
	String loginValidate(User user);
}
