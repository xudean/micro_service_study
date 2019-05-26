package org.virtue.master.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.virtue.master.pojo.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
