package org.virtue.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.virtue.basic.result.BizResult;
import org.virtue.dao.StudentRepository;
import org.virtue.pojo.Student;
import org.virtue.util.GenChineseName;


import java.util.List;
import java.util.Random;

@Controller
public class StudentController {
    private static final Integer SIZE_OF_EVERY_PAGE = 20;
    @Autowired
    private StudentRepository studentRepository;

    @ResponseBody
    @RequestMapping(value = "/students", method = {RequestMethod.GET})
    public List<Student> showStudents() {
        List<Student> students = studentRepository.findAll();
        return students;
    }

    @ResponseBody
    @RequestMapping(value = "/students", method = {RequestMethod.POST})
    public String addStudent(@RequestBody Student student) {
        studentRepository.save(student);
        return "OK";
    }

    @ResponseBody
    @RequestMapping(value = "/students/{studentId}", method = {RequestMethod.DELETE})
    public String deleteStudent(@PathVariable long studentId) {
        studentRepository.deleteById(studentId);
        return "OK";
    }

    @ResponseBody
    @RequestMapping(value = "/students", method = {RequestMethod.PUT})
    public BizResult updateStudent(@RequestBody Student student) {
        studentRepository.save(student);
        BizResult bizResult = BizResult.success();
        bizResult.setData("更新成功");
        bizResult.setMessage("测试");
        return bizResult;
    }

    @RequestMapping(value = "/students/add", method = {RequestMethod.GET})
    public void insertStudent() {
        //插入1000条学生信息用做出测试
        for (int i = 0; i < 1000; i++) {
            Random random = new Random();
            int age = random.nextInt(50);
            int gender = random.nextInt(2);
            String name = GenChineseName.getName();
            Student student = new Student();
            student.setAge(age);
            student.setGender(gender);
            student.setStudentName(name);
            studentRepository.save(student);
            System.out.println("开始插入第" + i + "条数据：" + student.toString());
        }
    }

    @ResponseBody
    @RequestMapping(value = "/students/{pagenum}", method = {RequestMethod.GET})
    public List<Student> pageabledQuery(@PathVariable int pagenum){
        Page<Student> students = studentRepository.findAll(PageRequest.of(pagenum-1, SIZE_OF_EVERY_PAGE));
        return students.getContent();
    }

    @ResponseBody
    @RequestMapping(value = "/students/age/{age}", method = {RequestMethod.GET})
    public List<Student> queryStudentByAge(@PathVariable int age){
        List<Student> students = studentRepository.findStudentByAge(age);
        return students;
    }

    @ResponseBody
    @RequestMapping(value = "/students/query", method = {RequestMethod.GET})
    public List<Student> quertSimple( String studentname){
        List<Student> students = studentRepository.findByStudentName(studentname);
        return students;
    }

    @ResponseBody
    @RequestMapping(value = "/students/endwith", method = {RequestMethod.GET})
    public List<Student> quertSimpleEndWith(String endname){
        List<Student> students = studentRepository.findByStudentNameEndsWith(endname);
        return students;
    }

    @ResponseBody
    @RequestMapping(value = "/students/sort", method = {RequestMethod.GET})
    public List<Student> testSort(String studentName){
        List<Student> students = studentRepository.findByStudentNameEndsWithAndSort(studentName, new Sort("age"));
        return students;
    }
}
