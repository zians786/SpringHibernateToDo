
package com.bridgeit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.bridgeit.dao.LoginDao;
import com.bridgeit.dao.RegistrationDao;
import com.bridgeit.model.User;

@Component
@Transactional
public class ServiceImp implements Service{

	@Autowired
	RegistrationDao register;
	@Autowired
	LoginDao login;
	
	public String registrationValidate(User user) {
		String result=register.emailValidaton(user);
		return result;
		}
	
	public String loginValidate(User user) {
		String result=login.loginValidate(user);
		return result;
		
	}
	
}
