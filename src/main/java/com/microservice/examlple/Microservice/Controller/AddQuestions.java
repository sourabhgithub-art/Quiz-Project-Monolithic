package com.microservice.examlple.Microservice.Controller;

import com.microservice.examlple.Microservice.Model.Question;
import com.microservice.examlple.Microservice.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("question")
public class AddQuestions {

    @Autowired
    QuestionService questionService;

    @GetMapping("getAllQuestions")
    public ResponseEntity<List<Question>> getAllQuestion(){
    try{
        return new ResponseEntity<>(questionService.getAllQuestion(),HttpStatus.OK);
    }catch (Exception e){
       e.printStackTrace();;
    }
    return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
    }

    @PostMapping("add")
    public ResponseEntity<Question>  addQuestion(@RequestBody Question question){
    return new  ResponseEntity(questionService.addQuestion(question), HttpStatus.OK) ;
    }

    @GetMapping("questionBycategory/{topic}")
    public ResponseEntity<List<Question>> getQuestionByCategory(@PathVariable String topic){
        return new ResponseEntity(questionService.getQuestionByCategory(topic), HttpStatus.OK);
    }

}

//engineer/cmt
