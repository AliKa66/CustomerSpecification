package com.bektas.customerspecification.controller;

import com.bektas.customerspecification.model.AnsweredQuestion;
import com.bektas.customerspecification.model.QuestionResponse;
import com.bektas.customerspecification.service.QuestionService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class TriviaController {

    private final QuestionService service;

    public TriviaController(QuestionService service) {
        this.service = service;
    }

    @GetMapping("questions")
    public Mono<List<QuestionResponse>> getQuestions(@RequestParam int amount) {
        return service.getQuestions(amount);
    }

    @PostMapping("checkanswer")
    public boolean checkAnswer(@RequestBody AnsweredQuestion answeredQuestion) {
        return service.isAnswerCorrect(answeredQuestion);
    }
}
