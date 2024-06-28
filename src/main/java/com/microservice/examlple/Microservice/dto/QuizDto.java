package com.microservice.examlple.Microservice.dto;

import com.microservice.examlple.Microservice.Model.Question;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuizDto {

    private Integer id;
    private String title;
    private String topic;
    private List<Question> questions;
}
