package com.microservice.examlple.Microservice.Service;

import com.microservice.examlple.Microservice.Model.Question;
import com.microservice.examlple.Microservice.Repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionRepository questionRepository;

    public Question addQuestion(Question req){
            return questionRepository.save(req);
    }

    public List<Question> getAllQuestion() {
        return questionRepository.findAll();
    }

    public List<Question> getQuestionByCategory(String topic) {
        return questionRepository.getQuestionByTopic(topic);
    }
}
