package com.example.ManageStudent.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ManageStudent.entity.Student;
import com.example.ManageStudent.repository.StudentRepository;

@Service
public class StudentServiceImplement implements StudentService {
	
	@Autowired
    private StudentRepository studentRepository;

	@Override
	public Iterable<Student> findAll() {
		// TODO Auto-generated method stub
		return studentRepository.findAll();
	}

	@Override
	public List<Student> search(String term) {
		// TODO Auto-generated method stub
		return studentRepository.findByNameContaining(term);
	}

	@Override
	public Optional<Student> findOne(int id) {
		// TODO Auto-generated method stub
		return studentRepository.findById(id);
	}

	@Override
	public void save(Student student) {
		// TODO Auto-generated method stub
		studentRepository.save(student);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		studentRepository.deleteById(id);
	}

}
