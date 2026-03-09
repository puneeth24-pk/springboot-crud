package com.puneeth.crudapp.repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.puneeth.crudapp.model.Student;

/*Repository Layer

A repository is responsible for interacting with the database.

Instead of writing database queries manually,
Spring Data MongoDB provides MongoRepository which automatically
gives us basic CRUD operations.

        CRUD = Create, Read, Update, Delete
*/
@Repository
public interface StudentRepository extends MongoRepository<Student, String>{
}

