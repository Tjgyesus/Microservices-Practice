package com.takeo.service;

import com.takeo.dao.UserDao;
import com.takeo.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserServices {
public User registerUser  (UserDao userDao);
public List<User> getUsers();

public Optional<User> findById(int id);
public List<User> getAllUsersWithCart();

public User checkLogin(String username, String password);


}
