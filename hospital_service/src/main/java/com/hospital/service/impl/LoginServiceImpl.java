package com.hospital.service.impl;

import com.hospital.dao.UserDao;
import com.hospital.entity.User;
import com.hospital.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("loginService")
public class LoginServiceImpl implements LoginService{
    @Autowired
    UserDao userDao;
    public User login(String username, String password) {
        User user = userDao.selectByName(username);
        if(user == null){
            return null;
        }
        if(!password.equals(user.getPassword())){
            return null;
        }
        return user;
    }
}
