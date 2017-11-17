
package com.bridgeit.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;

import com.bridgeit.model.User;

@Repository("registrationDao")
public class RegistrationDaoImp implements RegistrationDao {

	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}



	public String emailValidaton(final User user) {

		Query query = getSession()
				.createQuery("select userName from User where email='" + user.getEmail() + "'");
		String result = (String) query.uniqueResult();
		String name;

		if (result != null) {
			name = "User Already Exist with this Email...";
		} else {
		getSession().save(user);
			name = "Registration Successfull, Please Login...";
		}

		return name;
	}

}
