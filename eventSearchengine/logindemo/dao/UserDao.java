package com.example.logindemo.dao;

public interface UserDao {

    String handleLogin(String username,String password);
    String handleRegister(String username,String password);
}
