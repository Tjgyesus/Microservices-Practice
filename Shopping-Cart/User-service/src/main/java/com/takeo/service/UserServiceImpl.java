package com.takeo.service;

import com.takeo.client.CartClient;
import com.takeo.dao.UserDao;
import com.takeo.entity.User;
import com.takeo.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserServices {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private CartClient cartClient;


    @Override
    public User registerUser(UserDao userDao) {
        User user = new User();
        user.setUsername(userDao.getUsername());
        user.setPassword(userDao.getPassword());
        user.setEmail(userDao.getEmail());
        user.setRole(userDao.getRole());
        User userSave = userRepo.save(user);
        return userSave;
    }

    @Override
    public List<User> getUsers() {
        List<User> userList = userRepo.findAll();

        return userList;
    }

    @Override
    public Optional<User> findById(int id) {
        Optional<User> userById = userRepo.findById(id);
        return userById;
    }

    @Override
    public List<User> getAllUsersWithCart() {
        List<User> userListWithCart = userRepo.findAll();
        userListWithCart.forEach(user -> user.setCarts(cartClient.getCartbyUserId(user.getUserId()))  );
        return userListWithCart;
    }

    @Override
    public User checkLogin(String username, String password) {
        return null;
    }
}
