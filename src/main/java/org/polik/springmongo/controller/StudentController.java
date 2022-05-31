package org.polik.springmongo.controller;

import org.polik.springmongo.model.Student;
import org.polik.springmongo.repository.StudentRepository;
import org.polik.springmongo.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Polik on 5/31/2022
 */
@RestController
@RequestMapping("/api/v1/students")
public record StudentController(StudentService service) {
    @GetMapping
    public List<Student> getAll() {
        return service.getAll();
    }

    @PostMapping
    public Student create(@RequestBody Student student) {
        return service.create(student);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable String id, @RequestBody Student student) {
        service.update(id, student);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        service.delete(id);
    }
}
