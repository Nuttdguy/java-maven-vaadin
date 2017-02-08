package com.app.service.addstudent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.model.entity.Student;
import com.app.repository.student.StudentRepository;

@Service
public class AddStudentServiceImpl implements AddStudentService {
	
	@Autowired
	private StudentRepository studentRepository;

	public void saveStudent(Student studentDAO) {
		Student student = new Student();
		
		student.setFirstName(studentDAO.getFirstName());
		student.setLastName(studentDAO.getLastName());
		student.setAge(studentDAO.getAge());
		student.setGender(studentDAO.getGender());
		
		studentRepository.save(student);
	}

}
