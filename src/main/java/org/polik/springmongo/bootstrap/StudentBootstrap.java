package org.polik.springmongo.bootstrap;

import lombok.extern.slf4j.Slf4j;
import org.polik.springmongo.model.Address;
import org.polik.springmongo.model.Gender;
import org.polik.springmongo.model.Student;
import org.polik.springmongo.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by Polik on 5/31/2022
 */
@Slf4j
@Component
public record StudentBootstrap(StudentRepository repository) implements CommandLineRunner {
    @Override
    public void run(String... args) {
        Address address = Address.builder()
                .city("Moscow")
                .country("USA")
                .postCode("1017")
                .build();

        Student student = Student.builder()
                .email("student1@gmail.com")
                .favouriteSubjects(List.of("Math", "Programming"))
                .firstName("Alex")
                .lastName("Sidorov")
                .totalSpentInBooks(BigDecimal.valueOf(10000.0))
                .gender(Gender.MALE)
                .address(address)
                .created(LocalDateTime.now())
                .build();

        if (!repository.existsByEmail(student.getEmail())) {
            repository.insert(student);
        } else {
            log.info("student with email: {} already exists", student.getEmail());
        }
    }
}
