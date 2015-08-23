package com.springmvc.dao;

import com.springmvc.model.User;

public interface UserDAO {
	public int insertUser(User user);

	public User getUser(int id);

}
