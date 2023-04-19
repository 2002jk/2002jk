package com.example.logindemo.DaoImpl;
import com.example.logindemo.dao.EventDao;
import com.example.logindemo.repository.EventRepository;
import com.example.logindemo.repository.UserRepository;
import com.example.logindemo.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.example.logindemo.entity.Event;
import java.util.Iterator;
import javax.swing.text.html.HTMLDocument;
import java.util.List;
@Repository
public class EventDaoImpl implements EventDao{
    @Autowired
    private EventRepository eventRepository;


    @Override
    public void eventStore(List<Result> effectiveUrls,int themeid){
        int size=effectiveUrls.size();
        for(int i=0;i<size;i++){
            Result result=effectiveUrls.get(i);
            Event event=new Event(themeid,result.time,result.title,result.content,result.Url);
            eventRepository.save(event);
        }
    }


    @Override
    public List<Event>findEventsbyThemeid(int themeid){
        return  eventRepository.findEventByThemeid(themeid);
    }
}
