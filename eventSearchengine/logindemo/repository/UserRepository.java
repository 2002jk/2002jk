package com.example.logindemo.repository;
import com.example.logindemo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
public interface UserRepository extends JpaRepository<User,Integer> {
    User findUserByUsername(String username);
    List<User>findAll();



}
