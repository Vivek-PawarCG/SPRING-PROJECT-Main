package com.cg.loan.service;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.loan.model.User;
import com.cg.loan.repository.IUserRepository;
import com.cg.loan.service.IUserService;
import com.cg.loan.service.UserServiceImpl;


@Service
public class UserServiceImpl implements IUserService {
	Logger logger = Logger.getLogger(UserServiceImpl.class.getName());
	@Autowired
	IUserRepository repository;
	
	public UserServiceImpl(IUserRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	public User addNewUser(User user) {
		
		try {
			repository.save(user);
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
			return user;
	}

	@Override
	public User signIn(User user) {
		
		return null;
	}

	@Override
	public User signOut(User user) {
		
		return null;
	}

}
