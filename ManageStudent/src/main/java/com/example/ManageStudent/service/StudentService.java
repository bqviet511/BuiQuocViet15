package com.example.ManageStudent.service;

import java.util.List;
import java.util.Optional;

import com.example.ManageStudent.entity.Student;

public interface StudentService {
	Iterable<Student> findAll();
    List<Student> search(String term);
    Optional<Student> findOne(int id);
    void save(Student student);
    void delete(Integer id);
}
