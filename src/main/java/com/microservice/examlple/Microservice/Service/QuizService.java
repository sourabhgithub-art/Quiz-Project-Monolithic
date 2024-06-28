package com.microservice.examlple.Microservice.Service;

import com.microservice.examlple.Microservice.Model.Question;
import com.microservice.examlple.Microservice.Model.Quiz;
import com.microservice.examlple.Microservice.Model.Response;
import com.microservice.examlple.Microservice.Repository.QuestionRepository;
import com.microservice.examlple.Microservice.Repository.QuizRepository;
import com.microservice.examlple.Microservice.dto.QuestionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    QuizRepository quizRepository;
     @Autowired
     QuestionRepository questionRepository;
    public Quiz createQuiz(String topic, int numQue, String title) {
        List<Question> questions = questionRepository.getRandomQuestionByTopic(topic,numQue);
        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
         return quizRepository.save(quiz);
    }

    public Integer getAllQuiz(Integer id, List<Response> response){
        List<Question> ques = quizRepository.findQuizById(id).getQuestions();;
        int right = 0;
        int i = 0;
        for(Response res : response){
            if(res.getResponse().equals(ques.get(i).getCorrectAnswer()))
                right++;
            i++;
        }
        return right;
    }

    public List<QuestionDto> getQuiz(int id) {
       Quiz quiz = quizRepository.findQuizById(id);
       List<Question> ques = quiz.getQuestions();
       List<QuestionDto> quesDto = new ArrayList<>();
       for(Question que : ques){
          QuestionDto qd = new QuestionDto();
          qd.setQId(que.getQId());
          qd.setQuestion(que.getQuestion());
          qd.setTopic(que.getTopic());
          qd.setOp1(que.getOp1());
           qd.setOp2(que.getOp2());
           qd.setOp3(que.getOp3());
           qd.setOp4(que.getOp4());
           quesDto.add(qd);
       }
        return quesDto;
    }
}
