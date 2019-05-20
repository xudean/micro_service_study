package org.virtue.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.virtue.pojo.Student;
import org.virtue.service.impl.StudentServiceImpl;

import java.util.List;

@Controller
public class StudentController {
    @Autowired
    private StudentServiceImpl studentService;
    @ResponseBody
    @RequestMapping(value = "/students", method = {RequestMethod.GET})
    public List<Student> students(String studentName){
        List<Student> students = studentService.findStudentByName(studentName);
        return students;
    }
}
