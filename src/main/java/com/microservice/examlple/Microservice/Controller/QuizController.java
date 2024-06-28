package com.microservice.examlple.Microservice.Controller;

import com.microservice.examlple.Microservice.Model.Question;
import com.microservice.examlple.Microservice.Model.Quiz;
import com.microservice.examlple.Microservice.Model.Response;
import com.microservice.examlple.Microservice.Service.QuizService;
import com.microservice.examlple.Microservice.dto.QuestionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {

   @Autowired
   QuizService quizService;

    @PostMapping("create")
    public ResponseEntity<Quiz> createQuiz(@RequestParam String topic, @RequestParam int numQue, @RequestParam String title){
       return new ResponseEntity<>(quizService.createQuiz( topic,  numQue,  title ), HttpStatus.CREATED);
    }

    @GetMapping("getQuiz/{id}")
    public ResponseEntity<List<QuestionDto>> gteQuiz(@PathVariable int id){
       try {
           //Quiz q =  quizService.getQuiz(id);
           List<QuestionDto> qDto = quizService.getQuiz(id);

           return new ResponseEntity<>(qDto,HttpStatus.OK);
       }catch (Exception e){
           e.printStackTrace();
       }
       return new ResponseEntity(new ArrayList<>(), HttpStatus.BAD_REQUEST);

    }

    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> calculateQuiz(@PathVariable Integer id, @RequestBody List<Response> response){
        int marks = quizService.getAllQuiz(id,response);
        return new ResponseEntity<>(marks, HttpStatus.OK);

    }
}
