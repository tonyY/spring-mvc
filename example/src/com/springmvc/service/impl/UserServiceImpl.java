package com.springmvc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.springmvc.dao.UserDAO;
import com.springmvc.model.User;
import com.springmvc.service.UserService;

@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;

	public int insertUser(User user) {
		// TODO Auto-generated method stub
		return userDAO.insertUser(user);
	}

	public User getUser(int id) {
		// TODO Auto-generated method stub
		return userDAO.getUser(id);
	}

}