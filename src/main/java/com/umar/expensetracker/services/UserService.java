package com.umar.expensetracker.services;

import com.umar.expensetracker.domain.User;
import com.umar.expensetracker.exceptions.EtAuthException;

public interface UserService {
	User validateuser(String email,String password) throws EtAuthException;

	User registeruser(String firstName,String lastName,String email,String password) throws EtAuthException;

}
