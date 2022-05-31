package org.polik.springmongo.service;

import lombok.extern.slf4j.Slf4j;
import org.polik.springmongo.model.Student;
import org.polik.springmongo.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Polik on 5/31/2022
 */
@Slf4j
@Service
public record StudentService(StudentRepository repository) {
    public List<Student> getAll() {
        return repository.findAll();
    }

    public void update(String id, Student student) {
        student.setId(id);
        repository.save(student);
    }

    public Student create(Student student) {
        return repository.insert(student);
    }

    public void delete(String id) {
        repository.deleteById(id);
    }
}
