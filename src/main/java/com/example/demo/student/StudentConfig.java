package com.example.demo.student;

import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {

                 Student mariam =   new Student(

                            "Mariame",
                            "mariame.jamel@gmail.com",
                            21
                    );
            Student alex =   new Student(

                    "Alex",
                    "alex.a@gmail.com",
                    21
            );
            repository.saveAll(
                     List.of(mariam, alex)
            );
        };
    }
}
