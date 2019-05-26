package org.virtue.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.virtue.basic.result.BizResult;
import org.virtue.master.dao.StudentRepository;
import org.virtue.master.pojo.Student;
import org.virtue.slave.dao.UserRepository;
import org.virtue.slave.pojo.User;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class MultiSouceController {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private UserRepository userRepository;
    @ResponseBody
    @RequestMapping(value = "/datasouces/data", method = {RequestMethod.GET})
    public Map<String,Object> updateStudent(){
        Map<String,Object> allData = new HashMap<>();
        List<Student> students = studentRepository.findAll();
        List<User> users = userRepository.findAll();
        allData.put("students",students);
        allData.put("users",users);
        return allData;
    }
}
