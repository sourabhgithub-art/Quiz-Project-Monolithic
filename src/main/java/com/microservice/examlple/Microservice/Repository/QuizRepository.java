package com.microservice.examlple.Microservice.Repository;

import com.microservice.examlple.Microservice.Model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizRepository extends JpaRepository<Quiz,Integer> {
    Quiz findQuizById(int id);
}
