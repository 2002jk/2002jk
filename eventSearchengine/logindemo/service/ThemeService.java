package com.example.logindemo.service;
import com.example.logindemo.entity.Theme;

import java.util.List;
public interface ThemeService {
    List<Theme>findAll();
    void createTheme(String theme);
    Theme findbyTheme(String theme);

}
