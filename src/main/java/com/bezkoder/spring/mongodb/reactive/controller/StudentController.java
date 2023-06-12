package com.bezkoder.spring.mongodb.reactive.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.bezkoder.spring.mongodb.reactive.model.Student;
import com.bezkoder.spring.mongodb.reactive.service.StudentService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class StudentController {

  final
  StudentService studentService;

  public StudentController(StudentService studentService) {
    this.studentService = studentService;
  }

  @GetMapping("/students")
  @ResponseStatus(HttpStatus.OK)
  public Flux<Student> getAllstudents(@RequestParam(required = false) String classe) {
    if (classe == null)
      return studentService.findAll();
    else
      return studentService.findAllByClasse(classe);
  }

  @GetMapping("/students/{id}")
  @ResponseStatus(HttpStatus.OK)
  public Mono<Student> getTutorialById(@PathVariable("id") String id) {
    return studentService.findById(id);
  }

  @PostMapping("/students")
  @ResponseStatus(HttpStatus.CREATED)
  public Mono<Student> createTutorial(@RequestBody Student student) {
    return studentService.save(new Student(student.getFirstName(), student.getLastName(), student.getClasse(),
            student.getNote(), student.isPayed(), student.getNotes()));
  }

  @PutMapping("/students/{id}")
  @ResponseStatus(HttpStatus.OK)
  public Mono<Student> updateTutorial(@PathVariable("id") String id, @RequestBody Student tutorial) {
    return studentService.update(id, tutorial);
  }

  @DeleteMapping("/students/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public Mono<Void> deleteTutorial(@PathVariable("id") String id) {
    return studentService.deleteById(id);
  }

  @DeleteMapping("/students")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public Mono<Void> deleteAllstudents() {
    return studentService.deleteAll();
  }

}
