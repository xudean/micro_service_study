package org.virtue.service;

import org.virtue.pojo.Student;

import java.util.List;

public interface IStudentService {
    List<Student> findStudentByName(String name);
}
