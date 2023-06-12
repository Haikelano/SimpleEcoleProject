package com.bezkoder.spring.mongodb.reactive.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.bezkoder.spring.mongodb.reactive.model.Student;
import reactor.core.publisher.Flux;

@Repository
public interface StudentRepository extends ReactiveMongoRepository<Student, String> {

    Flux<Student> findAllByClasseContaining(String title);
}
