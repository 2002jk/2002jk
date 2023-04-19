package com.example.logindemo.DaoImpl;
import com.example.logindemo.dao.UserDao;
import com.example.logindemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.example.logindemo.entity.User;
import java.util.Iterator;
import javax.swing.text.html.HTMLDocument;
import java.util.List;
@Repository
public class UserDaoImpl implements UserDao{
    @Autowired
    private UserRepository userRepository;

    @Override
    public String handleLogin(String username,String password){
        List<User>userList=userRepository.findAll();
        Iterator<User>it=userList.iterator();
        while (it.hasNext()){
            User user=it.next();
            if(user.getUsername().equals(username)&&user.getPassword().equals(password)){
                return "success";
            }
        }
        return "failed";
    }

    @Override
    public String handleRegister(String username,String password){
        List<User>userList=userRepository.findAll();
        Iterator<User>it=userList.iterator();
        while (it.hasNext()){
            User user=it.next();
            if(user.getUsername().equals(username)){
                return "用户名已存在！";
            }
        }
        User user=new User(username,password);
        userRepository.save(user);
        return "注册成功！";
    }


}
