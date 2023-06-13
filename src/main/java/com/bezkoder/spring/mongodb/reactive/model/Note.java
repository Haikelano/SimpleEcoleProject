package com.bezkoder.spring.mongodb.reactive.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by @hmaaoui
 **/
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Note {
    private String nameMatier;
    private float note;
}
