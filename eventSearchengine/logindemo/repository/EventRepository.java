package com.example.logindemo.repository;
import com.example.logindemo.entity.Event;
import com.example.logindemo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
public interface EventRepository extends JpaRepository<Event,Integer>{
    @Query(value="select * from events a where a.themeid=:themeid",nativeQuery = true)
     List<Event>findEventByThemeid(int themeid);
}
