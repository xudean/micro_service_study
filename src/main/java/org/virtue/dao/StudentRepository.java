package org.virtue.dao;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.virtue.pojo.Student;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findStudentByAge(int age);

    @Query("select s from Student s where s.studentName = ?1")
    List<Student> findByStudentName(String studentName);

    @Query("select s from Student s where s.studentName like %?1")
    List<Student> findByStudentNameEndsWith(String firstname);

    @Query("select s from Student s where s.studentName like ?1%")
    List<Student> findByStudentNameEndsWithAndSort(String studentName, Sort sort);
}
