package com.example.logindemo.service;

import  com.example.logindemo.entity.User;
import java.util.List;

public interface UserService {
String handleLogin(String username,String password);
String handleRegister(String username,String password);


}