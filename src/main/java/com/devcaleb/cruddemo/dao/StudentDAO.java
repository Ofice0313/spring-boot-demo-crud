package com.devcaleb.cruddemo.dao;

import com.devcaleb.cruddemo.entities.Student;

import java.util.List;

public interface StudentDAO {

    void save(Student student);

    Student findById(Integer id);

    List<Student> findAll();

    List<Student> findByLastName(String lastName);

    void update(Student student);
}
