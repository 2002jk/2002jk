package com.example.logindemo.dao;

import com.example.logindemo.entity.Theme;
import java.util.List;
public interface ThemeDao {
    List<Theme>findAll();
    void createTheme(String theme);
    Theme findbyTheme(String theme);
}
