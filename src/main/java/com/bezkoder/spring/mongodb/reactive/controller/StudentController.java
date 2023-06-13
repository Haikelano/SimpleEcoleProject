package com.bezkoder.spring.mongodb.reactive.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
  @PostMapping("/students")
  @ResponseStatus(HttpStatus.CREATED)
  public Mono<Student> createStudent(@RequestBody Student student) {
    return studentService.save(new Student(student.getFirstName(), student.getLastName(), student.getClasse(),
            student.getNote(), student.isPayed(), student.getNotes()));
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
  public Mono<Student> getStudentById(@PathVariable("id") String id) {
    return studentService.findById(id);
  }


  @PutMapping("/students/{id}")
  @ResponseStatus(HttpStatus.OK)
  public Mono<Student> updateStudent(@PathVariable("id") String id, @RequestBody Student student) {
    return studentService.update(id, student);
  }

  @DeleteMapping("/students/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public Mono<Void> deleteStudent(@PathVariable("id") String id) {
    return studentService.deleteById(id);
  }

  @PatchMapping("/students/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public Mono<Student> updatePayment(@PathVariable("id") String id) {
    Student student = studentService.findById(id).block();
    assert student != null;
    student.setPayed(!student.isPayed());
    return studentService.patchPayment(student);
  }

  @DeleteMapping("/students")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public Mono<Void> deleteAllstudents() {
    return studentService.deleteAll();
  }

}
