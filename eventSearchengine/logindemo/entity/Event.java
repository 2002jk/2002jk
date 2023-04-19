package com.example.logindemo.entity;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "events")
@JsonIgnoreProperties(value = {"handler","hibernateLazyInitializer","fieldHandler"})
public class Event {
    private int eventid;
    private int themeid;
    private Date time;
    private String title;
    private String content;
    private String url;
    public Event(){}
    public Event(int themeid,Date time,String title,String content,String url){
        this.themeid=themeid;
        this.time=time;
        this.title=title;
        this.content=content;
        this.url=url;
    }
    @Id
    @Column(name="eventid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getEventid(){return eventid;}
    public void setEventid(int eventid) {
        this.eventid = eventid;
    }


    @Basic
    @Column(name="themeid")
    public int getTheme(){return themeid;}
    public void setTheme(int themeid) {
        this.themeid = themeid;
    }

    @Basic
    @Column(name="time")
    public Date getTime(){return time;}
    public void setTime(Date time) {
        this.time = time;
    }

    @Basic
    @Column(name="title")
    public String getTitle(){return title;}
    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name="content")
    public String getContent(){return content;}
    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(name="url")
    public String getUrl(){return url;}
    public void setUrl(String url) {
        this.url = url;
    }
}
