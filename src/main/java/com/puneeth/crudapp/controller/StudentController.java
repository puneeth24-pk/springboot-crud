package com.puneeth.crudapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.puneeth.crudapp.model.Student;
import com.puneeth.crudapp.service.StudentService;

/*
 Controller Layer

 The controller is responsible for handling HTTP requests from clients
 such as browsers, mobile apps, or Postman.

 Example requests:
 GET /students
 POST /students
 PUT /students
 DELETE /students/{id}

 The controller does NOT talk directly to the database.
 Instead, it communicates with the Service layer.

 Flow:
 Client → Controller → Service → Repository → MongoDB
*/

@RestController
// Marks this class as a REST API controller.
// Spring Boot will detect it and allow it to handle HTTP requests.

@RequestMapping("/students")
// Base URL for all APIs inside this controller.
// Every endpoint will start with /students
// Example: GET /students , POST /students

public class StudentController {

    @Autowired
    /*
     Dependency Injection

     Spring automatically creates an object of StudentService
     and injects it here.

     Instead of manually creating:
     StudentService service = new StudentService();

     Spring manages the object automatically.
    */
    private StudentService service;


    @PostMapping
    /*
     Handles HTTP POST requests.

     API endpoint:
     POST /students

     Used to create a new student.
    */
    public Student addStudent(@RequestBody Student student){

        /*
         @RequestBody

         Converts incoming JSON data into a Java Student object.

         Example request body:

         {
           "name": "Puneeth",
           "age": 19,
           "department": "AI"
         }

         Spring automatically converts this JSON into:

         Student student = new Student();
         student.setName("Puneeth");
         student.setAge(19);
         student.setDepartment("AI");
        */

        /*
         Call the Service layer method.

         Controller should NOT interact with the database directly.

         Instead it calls the service method.
        */
        return service.saveStudent(student);
    }



    @GetMapping
    /*
     Handles HTTP GET requests.

     API endpoint:
     GET /students

     Used to fetch all students from the database.
    */
    public List<Student> getStudents(){

        /*
         Calls the Service layer to retrieve students.

         Service layer will call Repository,
         and Repository will fetch data from MongoDB.
        */
        return service.getStudents();
    }



    @PutMapping
    /*
     Handles HTTP PUT requests.

     API endpoint:
     PUT /students

     Used to update existing student data.
    */
    public Student updateStudent(@RequestBody Student student){

        /*
         @RequestBody converts JSON request into Student object.

         If the student ID exists → MongoDB updates the record.
         If ID does not exist → MongoDB inserts new record.
        */
        return service.updateStudent(student);
    }



    @DeleteMapping("/{id}")
    /*
     Handles HTTP DELETE requests.

     API endpoint:
     DELETE /students/{id}

     Example:
     DELETE /students/65fa21
    */
    public String deleteStudent(@PathVariable String id){

        /*
         @PathVariable extracts value from URL.

         Example URL:
         DELETE /students/123

         Spring extracts:
         id = "123"
        */

        /*
         Call service layer to delete the student.
         Service layer will call repository.deleteById(id)
        */
        service.deleteStudent(id);

        return "Student deleted successfully";
    }
}