package com.puneeth.crudapp.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
/*Model Class

A model class represents the structure of data in the application.
In Spring Boot with MongoDB, each model class corresponds to a MongoDB collection.

Example:
Student class → "students" collection in MongoDB

Each object of this class becomes one document in the database.
        */
@Document(collection = "students")
public class Student {
    @Id
    //@Id marks the primary key of the document
    //mongo db will automatically genarate unique id for each  student
    private String id;
    //student name field
    private String name;
    //student age field
    private int age;
    //student department field
    private String department;

    public Student(){}
    public String getId(){
        return id;
    }
    public void setId(String id){
        this.id =id;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
    public int getAge(){
        return age;
    }
    public void setAge(int age){
        this.age=age;
    }
    public String getDepartment(){
        return department;
    }
    public void setDepartment(String department){
        this.department=department;
    }
}
