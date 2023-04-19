package com.example.logindemo.service;
import com.example.logindemo.entity.Event;
import com.example.logindemo.result.Result;

import java.util.List;

public interface EventService {
    void eventStore(List<Result> effectiveUrls,int themeid);
    List<Event>findEventsbyThemeid(int themeid);
}
