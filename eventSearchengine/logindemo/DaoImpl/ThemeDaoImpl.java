package com.example.logindemo.DaoImpl;
import com.example.logindemo.dao.EventDao;
import com.example.logindemo.dao.ThemeDao;
import com.example.logindemo.repository.*;
import com.example.logindemo.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.example.logindemo.entity.*;
import java.util.Iterator;
import javax.swing.text.html.HTMLDocument;
import java.util.List;
@Repository
public class ThemeDaoImpl implements ThemeDao {
    @Autowired
    private ThemeRepository themeRepository;
    @Override
    public List<Theme>findAll(){
        return themeRepository.findAll();
    }
    @Override
    public void createTheme(String theme){
        Theme theme1=new Theme(theme);
        themeRepository.save(theme1);
    }

    @Override
    public Theme findbyTheme(String theme){
        return themeRepository.findThemeByTheme(theme);
    }


}
