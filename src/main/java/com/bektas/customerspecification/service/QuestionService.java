package com.bektas.customerspecification.service;

import com.bektas.customerspecification.TriviaWebClient;
import com.bektas.customerspecification.mapper.TriviaApiResponseMapper;
import com.bektas.customerspecification.model.AnsweredQuestion;
import com.bektas.customerspecification.model.QuestionResponse;
import com.bektas.customerspecification.model.TriviaApiResponse;
import com.bektas.customerspecification.model.TriviaResult;
import com.bektas.customerspecification.repository.TriviaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {

    private final TriviaRepository repository;

    private final TriviaWebClient webClient;

    private final TriviaApiResponseMapper mapper;

    public QuestionService(TriviaRepository repository, TriviaWebClient webClient, TriviaApiResponseMapper mapper) {
        this.repository = repository;
        this.webClient = webClient;
        this.mapper = mapper;
    }


    public Mono<List<QuestionResponse>> getQuestions(int amount) {
        return webClient
                .getQuestions(amount)
                .doOnNext(res -> repository.setResults(res.getResults()))
                .map(mapper::toListOfQuestions);
    }

    public boolean isAnswerCorrect(AnsweredQuestion answeredQuestion) {
        var results = repository.getResults();
        if (results == null) return false;

        Optional<TriviaResult> result = results
                .stream()
                .filter(res -> res.getQuestion().equalsIgnoreCase(answeredQuestion.getQuestion()))
                .findFirst();

        return result
                .map(triviaResult -> triviaResult.getCorrectAnswer().equalsIgnoreCase(answeredQuestion.getAnswer()))
                .orElse(false);
    }
}
