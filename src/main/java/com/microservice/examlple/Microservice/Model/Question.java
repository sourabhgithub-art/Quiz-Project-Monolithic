package com.microservice.examlple.Microservice.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long qId;
    private String difficultyLevel;
    private String topic;
    private String question;
    private String op1;
    private String op2;
    private String op3;
    private String op4;
    private String correctAnswer;
}
