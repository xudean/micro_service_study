package org.virtue.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.virtue.basic.result.BizResult;
import org.virtue.dao.StudentRepository;
import org.virtue.pojo.Student;


import java.util.List;

@Controller
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;
    @ResponseBody
    @RequestMapping(value = "/students", method = {RequestMethod.GET})
    public List<Student> showStudents(){
        List<Student> students = studentRepository.findAll();
        return students;
    }

    @ResponseBody
    @RequestMapping(value = "/students", method = {RequestMethod.POST})
    public String addStudent(@RequestBody Student student){
        studentRepository.save(student);
        return "OK";
    }

    @ResponseBody
    @RequestMapping(value = "/students/{studentId}", method = {RequestMethod.DELETE})
    public String deleteStudent(@PathVariable long studentId){
        studentRepository.deleteById(studentId);
        return "OK";
    }

    @ResponseBody
    @RequestMapping(value = "/students", method = {RequestMethod.PUT})
    public BizResult updateStudent(@RequestBody Student student){
        studentRepository.save(student);
        BizResult bizResult = BizResult.success();
        bizResult.setData("更新成功");
        bizResult.setMessage("测试");
        return bizResult;
    }
}
