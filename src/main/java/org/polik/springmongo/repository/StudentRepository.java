package org.polik.springmongo.repository;

import org.polik.springmongo.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by Polik on 2/1/2022
 */
public interface StudentRepository extends MongoRepository<Student, String> {
    boolean existsByEmail(String email);
}
