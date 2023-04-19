package com.example.logindemo.serviceImpl;
import com.example.logindemo.dao.EventDao;
import com.example.logindemo.dao.UserDao;
import com.example.logindemo.entity.Event;
import com.example.logindemo.result.Result;
import com.example.logindemo.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImpl implements EventService{

    @Autowired
    private EventDao eventDao;
    @Override
    public void eventStore(List<Result> effectiveUrls,int themeid){
        eventDao.eventStore(effectiveUrls,themeid);
    }
    @Override
    public List<Event>findEventsbyThemeid(int themeid){
        return eventDao.findEventsbyThemeid(themeid);
    }


}
