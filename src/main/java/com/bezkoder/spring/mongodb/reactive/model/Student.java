package com.bezkoder.spring.mongodb.reactive.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Student {

  @Id
  private String id;
  @NotBlank
  @Size(min = 3, max = 25)
  private String firstName;
  @NotBlank
  @Size(min = 3, max = 25)
  private String lastName;
  private String classe;
  private float note;
  private boolean payed;
  private List<Note> notes;

  public Student(String firstName, String lastName, String classe,
                 float note, boolean payed, List<Note> notes) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.classe = classe;
    this.note = note;
    this.payed = payed;
    this.notes = notes;
  }
}
