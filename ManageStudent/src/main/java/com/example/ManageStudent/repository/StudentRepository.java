package com.example.ManageStudent.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.ManageStudent.entity.Student;

import java.util.List;

@Repository
public interface StudentRepository extends CrudRepository<Student, Integer>, JpaSpecificationExecutor<Student> {
    public List<Student> findByNameContaining(String name);
}	