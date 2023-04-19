package com.example.logindemo.serviceImpl;
import com.example.logindemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.logindemo.dao.UserDao;
@Service
public class UserServiceImpl implements UserService{


    @Autowired
    private UserDao userDao;

    @Override
    public String handleLogin(String username,String password){
       return   userDao.handleLogin(username,password);
    }

    @Override
    public String handleRegister(String username,String password){
        return userDao.handleRegister(username,password);
    }



}
