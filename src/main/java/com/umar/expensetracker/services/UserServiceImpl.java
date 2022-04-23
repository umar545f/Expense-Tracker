package com.umar.expensetracker.services;

import com.umar.expensetracker.domain.User;
import com.umar.expensetracker.exceptions.EtAuthException;
import com.umar.expensetracker.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;


@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepository;

	@Override
	public User validateuser(String email, String password) throws EtAuthException {
		if(email != null) email = email.toLowerCase();
		return userRepository.findByEmailAndPassword(email, password);
	}

	@Override
	public User registeruser(String firstName, String lastName, String email, String password) throws EtAuthException {
		Pattern pattern = Pattern.compile("^(.+)@(.+)$");
		if(email != null) email = email.toLowerCase();
		if(!pattern.matcher(email).matches())
			throw new EtAuthException("Invalid email format");
		Integer count = userRepository.getCountBtEmail(email);
		if(count > 0)
			throw new EtAuthException("Email already in use");
		Integer userId = userRepository.create(firstName, lastName, email, password);
		return userRepository.findById(userId);
	}
}
