package com.puneeth.crudapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.puneeth.crudapp.model.Student;
import com.puneeth.crudapp.repository.StudentRepository;

/*
 Service Layer

 The service layer contains business logic of the application.

 It acts as a bridge between Controller and Repository.

 Controller → Service → Repository → Database
*/
@Service
//it will class as spring service component and it will automatically
//create an objcet of this class
public class StudentService{
    @Autowired
    private StudentRepository repo;
    public Student saveStudent(Student student){
        return repo.save(student);
    }
    public List<Student> getStudents(){
        return repo.findAll();
    }
    public  void deleteStudent(String id){
        repo.deleteById(id);
    }
    public Student updateStudent(Student student){
        return repo.save(student);
    }

}