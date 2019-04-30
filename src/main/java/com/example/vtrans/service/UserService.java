package com.example.vtrans.service;

import com.example.vtrans.pojo.User;

public interface UserService {

    User testingMail(String mail);

    User getUser(String mail, String pass);
}
