package com.example.userapi;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.userapi.dao.entity.Student;
import com.example.userapi.dao.entity.StudentRepository;

@RestController
public class StudentController {

	@Autowired
	StudentRepository studentRepository;

	@RequestMapping("/students")
	public List<Student> getStudents() {
		return (List<Student>) studentRepository.findAll();
	}
	
	@RequestMapping(value = "/student/{id}", method = RequestMethod.GET)
	public Student addStudent(@PathVariable("id") String id) {
		Long idLong=Long.parseLong(id);
		return studentRepository.findById(idLong).get();
	}

	@RequestMapping(value = "/student", method = RequestMethod.POST)
	public boolean addStudents(@RequestBody Student student) {
		if (student != null) {
			if (studentRepository.save(student) != null) {
				return true;
			}
		}
		return false;
	}

	@RequestMapping(value = "/student/{id}", method = RequestMethod.DELETE)
	public boolean deleteStudent(@PathVariable("id") String id) {
		Long idLong=Long.parseLong(id);
		studentRepository.deleteById(idLong);
		return true;
	}

	@RequestMapping(value = "/student/{id}", method = RequestMethod.PUT)
	public boolean updateStudents(@PathVariable("id") String id, @RequestBody Student student) {
		Long idLong=Long.parseLong(id);
		student.setSid(idLong);
		if (studentRepository.save(student) != null) {
			return true;
		}
		return false;
	}
	

}
