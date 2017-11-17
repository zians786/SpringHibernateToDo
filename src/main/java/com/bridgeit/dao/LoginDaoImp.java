
package com.bridgeit.dao;

import java.sql.ResultSet;

import java.sql.SQLException;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bridgeit.model.User;


@Repository("loginDao")
public class LoginDaoImp implements LoginDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}


	@Override
	public String loginValidate(User user) {
	Query query=getSession().createQuery("select email from User where userName='" +user.getUserName() + "' and password='"+user.getPassword()+"'");
	String result=(String) query.uniqueResult();	
	String name=null;
	if (result!=null) {
		name="true";
	}
	return name;
	}	
}
