package com.vismee.hibernatejpa;

import com.vismee.hibernatejpa.dao.StudentDAO;
import com.vismee.hibernatejpa.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class HibernatejpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(HibernatejpaApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO)
	{
		return runner -> {
			// createStudent(studentDAO);
			// createMultipleStudents(studentDAO);
			// findStudentById(studentDAO);
			// findAllStudents(studentDAO);
			// findStudentsByLastName(studentDAO);
			// updateStudent(studentDAO);
			// updateAllStudents(studentDAO);
			// deleteStudent(studentDAO);
			 deleteAllStudent(studentDAO);
		};
	}

	private void deleteAllStudent(StudentDAO studentDAO) {
		studentDAO.deleteAll();
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId = 1;
		System.out.println("Deleting a student in db");
		studentDAO.delete(studentId);
	}

	private void updateAllStudents(StudentDAO studentDAO) {
		studentDAO.updateAll();
	}

	private void updateStudent(StudentDAO studentDAO)
	{
		int id = 1;
		Student student = studentDAO.findById(id);
		student.setEmail("meenuvisu@gmail.com");
		System.out.println("Updating the student in db table");
		studentDAO.update(student);
	}

	private void findStudentsByLastName(StudentDAO studentDAO) {
		System.out.println("Fetching student based on a lastName");
		List<Student> students = studentDAO.findByLastName("Visu");
		for(Student student : students)
		{
			System.out.println(student);
		}
	}

	private void findAllStudents(StudentDAO studentDAO) {
		System.out.println("Fetching all students");
		List<Student> students = studentDAO.findAll();
		for(Student student : students)
		{
			System.out.println(student);
		}
	}

	private void findStudentById(StudentDAO studentDAO) {
		System.out.println("Finding student by primary key");
		Student student = new Student("Bhargav","Visu","Parithi@gmail.com");
		studentDAO.save(student);
		System.out.println("Generated id value " +student.getId());
		Student st = studentDAO.findById(student.getId());
		System.out.println("Retrieved student " +st);

	}

	private void createMultipleStudents(StudentDAO studentDAO)
	{
		System.out.println("Saving multiple students in db table");
		Student stud1 = new Student("Meenu","Visu","MeenuVisu@gmail.com");
		Student stud2 = new Student("Swetha","Sabari","SweSabari@gmail.com");
		Student stud3 = new Student("abc","def","abcd@gmail.com");

		studentDAO.save(stud1);
		studentDAO.save(stud2);
		studentDAO.save(stud3);
	}

	private void createStudent(StudentDAO studentDAO)
	{
		System.out.println("Saving a new student in db table");
		Student student = new Student("abc","xyz","meenuvisuxyz@gmail.com");
		studentDAO.save(student);
		System.out.println("Generated id value " +student.getId());

	}
}
