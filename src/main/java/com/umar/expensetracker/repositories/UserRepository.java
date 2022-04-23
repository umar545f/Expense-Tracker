package com.umar.expensetracker.repositories;

import com.umar.expensetracker.domain.User;
import com.umar.expensetracker.exceptions.EtAuthException;

public interface UserRepository {
	Integer create(String firstName,String lastName,String email,String password) throws EtAuthException;

	User findByEmailAndPassword(String email, String password) throws EtAuthException;

	Integer getCountBtEmail(String email);

	User findById(Integer userId);
}
