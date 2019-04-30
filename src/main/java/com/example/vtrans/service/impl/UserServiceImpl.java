package com.example.vtrans.service.impl;

import com.example.vtrans.dao.UserDao;
import com.example.vtrans.pojo.User;
import com.example.vtrans.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public User testingMail(String mail){
        return userDao.testingMail(mail);
    }

    public User getUser(String mail, String pass){
        return userDao.getUser(mail,pass);
    }
}
