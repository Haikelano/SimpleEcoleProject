package com.bezkoder.spring.mongodb.reactive.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bezkoder.spring.mongodb.reactive.model.Student;
import com.bezkoder.spring.mongodb.reactive.repository.StudentRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class StudentService {

  final
  StudentRepository studentRepository;

  public StudentService(StudentRepository studentRepository) {
    this.studentRepository = studentRepository;
  }

  public Flux<Student> findAll() {
    return studentRepository.findAll();
  }


  public Mono<Student> findById(String id) {
    return studentRepository.findById(id);
  }

  public Mono<Student> save(Student student) {
    return studentRepository.save(student);
  }

  public Mono<Student> update(String id, Student student) {
    return studentRepository.findById(id).map(Optional::of).defaultIfEmpty(Optional.empty())
        .flatMap(optionalTutorial -> {
          if (optionalTutorial.isPresent()) {
            student.setId(id);
            return studentRepository.save(student);
          }

          return Mono.empty();
        });
  }

  public Mono<Void> deleteById(String id) {
    return studentRepository.deleteById(id);
  }

  public Mono<Void> deleteAll() {
    return studentRepository.deleteAll();
  }

  public Flux<Student> findAllByClasse(String classeName) {
    return studentRepository.findAllByClasseContaining(classeName);
  }
}
