package org.virtue.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.virtue.dao.UserRepository;
import org.virtue.pojo.ServiceUser;


import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @ResponseBody
    @RequestMapping(value = "/users", method = {RequestMethod.GET})
    public List<ServiceUser> showUsers(){
        List<ServiceUser> students = userRepository.findAll();
        return students;
    }

    @ResponseBody
    @RequestMapping(value = "/users/{userId}", method = {RequestMethod.GET})
    public ServiceUser selectUserById(@PathVariable Long userId){
        ServiceUser serviceUser = userRepository.findById(userId).get();
        return serviceUser;
    }

}
