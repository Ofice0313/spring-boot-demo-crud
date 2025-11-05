package com.devcaleb.cruddemo;

import com.devcaleb.cruddemo.dao.StudentDAO;
import com.devcaleb.cruddemo.entities.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication{

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {

		return runner -> {
			updateStudent(studentDAO);
		};
	}

	private void updateStudent(StudentDAO studentDAO) {

		// retrieve student based one the is: primary key
		int studentId = 3;
		System.out.println("Getting student with id: " + studentId);
		Student myStudent = studentDAO.findById(studentId);

		// change first name to "Lina"
		System.out.println("Update student ...");
		myStudent.setFirstName("Lina");

		// update the student
		studentDAO.update(myStudent);

		// display the updated student
		System.out.println("Updated student: " + myStudent);
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		//get a list of students
		List<Student> students = studentDAO.findByLastName("Simbine");

		// display list of students
		for(Student student: students) {
			System.out.println(student);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {
		// get a list of students
		List<Student> theStudents = studentDAO.findAll();

		// display list of Students
		for(Student student: theStudents) {
			System.out.println(student);
		}
	}

	private void readStudent(StudentDAO studentDAO) {

		// create a student object
		System.out.println("Creating new student object ...");
		Student student1 = new Student("Leocadia", "Simbine", "leocadia@gmail.com");

		// save the student
		System.out.println("Saving the student ...");
		studentDAO.save(student1);

		// display id of the saved the student
		int theId = student1.getId();
		System.out.println("Saved student. Generated id: " + theId);

		// retrieve student based on the id: primary key
		System.out.println("Retrieving student with id: " + theId);
		Student myStudent = studentDAO.findById(theId);

		// display student
		System.out.println("Found the student: " + myStudent);
	}

	private void createMultipleStudents(StudentDAO studentDAO) {

		// create the student object
		System.out.println("Creating multiples students objects ...");
		Student student1 = new Student("Leong", "Fat wa", "leong@gmail.com");
		Student student2 = new Student("Delmira", "Simbine", "delmira@gmail.com");
		Student student3 = new Student("Samiro", "Simbine", "samiro@gmail.com");

		studentDAO.save(student1);
		studentDAO.save(student2);
		studentDAO.save(student3);
	}

	private void createStudent(StudentDAO studentDAO) {
		// create the student object
		System.out.println("Creating new student object ...");
		Student student = new Student("Marcelo", "Ofice", "ofice@gmail.com");

		//save the student object
		System.out.println("Saving the student ...");
		studentDAO.save(student);

		// display id of the saved student
		System.out.println("Saved student. Generated id: " + student.getId());
	}


}
