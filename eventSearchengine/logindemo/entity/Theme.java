package com.example.logindemo.entity;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import javax.persistence.*;
import java.util.Date;



@Entity
@Table(name = "themes")
@JsonIgnoreProperties(value = {"handler","hibernateLazyInitializer","fieldHandler"})
public class Theme {
    private int themeid;
    private String theme;
    public Theme(){}
    public Theme(String theme){
        this.theme=theme;
    }

    @Id
    @Column(name="themeid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getThemeid(){return themeid;}
    public void setThemeid(int themeid) {
        this.themeid = themeid;
    }

    @Basic
    @Column(name="theme")
    public String getTheme(){return theme;}
    public void setTheme(String theme) {
        this.theme = theme;
    }
}
