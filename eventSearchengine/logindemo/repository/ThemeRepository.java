package com.example.logindemo.repository;
import com.example.logindemo.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
public interface ThemeRepository extends JpaRepository<Theme,Integer>{
    Theme findThemeByTheme(String theme);
}
