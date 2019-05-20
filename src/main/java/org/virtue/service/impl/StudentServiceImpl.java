package org.virtue.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.virtue.mapper.StudentMapper;
import org.virtue.pojo.Student;
import org.virtue.pojo.StudentExample;
import org.virtue.service.IStudentService;

import java.util.List;

@Service
public class StudentServiceImpl implements IStudentService {
    @Autowired
    private StudentMapper studentMapper;
    @Override
    public List<Student> findStudentByName(String name) {
        StudentExample studentExample = new StudentExample();
        studentExample.createCriteria().andStudentNameEqualTo(name);
        List<Student> students = studentMapper.selectByExample(studentExample);
        return students;
    }
}
