package com.example.logindemo.serviceImpl;
import com.example.logindemo.dao.EventDao;
import com.example.logindemo.dao.ThemeDao;
import com.example.logindemo.dao.UserDao;
import com.example.logindemo.entity.Event;
import com.example.logindemo.entity.Theme;
import com.example.logindemo.result.Result;
import com.example.logindemo.service.EventService;
import com.example.logindemo.service.ThemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ThemeServiceImpl implements ThemeService {


    @Autowired
    private ThemeDao themeDao;

    @Override
    public List<Theme>findAll(){
        return  themeDao.findAll();
    }

    @Override
    public void createTheme(String theme){
        themeDao.createTheme(theme);
    }


    @Override
    public Theme findbyTheme(String theme){
        return themeDao.findbyTheme(theme);
    }




}
