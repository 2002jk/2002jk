package com.example.logindemo.dao;

import com.example.logindemo.entity.Event;
import com.example.logindemo.result.Result;

import java.util.List;

public interface EventDao {
 void eventStore(List<Result> effectiveUrls,int themeid);
 List<Event>findEventsbyThemeid(int themeid);
}
