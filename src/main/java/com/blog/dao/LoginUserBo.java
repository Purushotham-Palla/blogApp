package com.blog.dao;

import java.util.List;

import com.blog.model.User;

public interface LoginUserBo {
	User userLogin(String email,String password);
	int userRegister(User log);
	List<User> getAllAdmins();

}
