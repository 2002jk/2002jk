package com.example.logindemo.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.example.logindemo.service.UserService;
@CrossOrigin
@RestController
public class Usercontroller {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login/{username}/{password}")
    @ResponseBody
    public String handleLogin(@PathVariable String username, @PathVariable String password){
         return JSON.toJSONString(userService.handleLogin(username,password));
    }



    @RequestMapping(value = "/register/{username}/{password}")
    @ResponseBody
    public String handleRegister(@PathVariable String username, @PathVariable String password){
        return JSON.toJSONString(userService.handleRegister(username,password));
    }
    


}
