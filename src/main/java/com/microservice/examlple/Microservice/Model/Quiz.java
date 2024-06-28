package com.microservice.examlple.Microservice.Model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String topic;
    @ManyToMany
    private List<Question> questions;

}
