package com.bektas.customerspecification.service;

import com.bektas.customerspecification.TriviaWebClient;
import com.bektas.customerspecification.mapper.TriviaApiResponseMapper;
import com.bektas.customerspecification.model.*;
import com.bektas.customerspecification.repository.TriviaRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.matchers.Any;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class QuestionServiceTest {

    private TriviaRepository repository;
    private TriviaApiResponseMapper mapper;
    private TriviaWebClient webClient;
    private QuestionService service;

    @BeforeEach
    void before() {
        repository = new TriviaRepository();
        mapper = Mockito.mock(TriviaApiResponseMapper.class);
        webClient = Mockito.mock(TriviaWebClient.class);
        service = new QuestionService(repository, webClient, mapper);
    }

    @Test
    void getQuestions_RunsWebClientGetQuestionsMethod_And_SetsResultToRepository_And_MapsToListOfQuestions() {
        TriviaApiResponse response = createApiResponse();
        List<QuestionResponse> questionsToSendToFrontend = createQuestionList();
        Mono<TriviaApiResponse> monoResponse = Mono.just(response);

        Mockito.when(mapper.toListOfQuestions(response))
                        .thenReturn(questionsToSendToFrontend);
        Mockito.when(webClient.getQuestions(Mockito.anyInt()))
                .thenReturn(monoResponse);

        List<QuestionResponse> questions =
                service.getQuestions(1).block();

        assertThat(questions).isNotNull();
        assertThat(questions.size()).isEqualTo(response.getResults().size());
        assertThat(repository.getResults())
                .isNotNull()
                .isEqualTo(response.getResults());
        Mockito.verify(webClient, Mockito.times(1)).getQuestions(Mockito.anyInt());
        Mockito.verify(mapper, Mockito.times(1)).toListOfQuestions(response);
    }

    @Test
    void checkAnswer_invalidAnswer_returnsFalse() {
        List<TriviaResult> results = List.of(getTriviaResult());
        repository.setResults(results);
        AnsweredQuestion answeredQuestion = new AnsweredQuestion("question", "incanswer");

        boolean isCorrect = service.isAnswerCorrect(answeredQuestion);

        assertThat(isCorrect).isFalse();
    }
    @Test
    void checkAnswer_NullResults_returnsFalse() {
        AnsweredQuestion answeredQuestion = new AnsweredQuestion("question", "incanswer");

        boolean isCorrect = service.isAnswerCorrect(answeredQuestion);

        assertThat(isCorrect).isFalse();
    }

    @Test
    void checkAnswer_validAnswer_returnsTrue() {
        List<TriviaResult> results = List.of(getTriviaResult());
        repository.setResults(results);
        AnsweredQuestion answeredQuestion = new AnsweredQuestion("question", "answer");

        boolean isCorrect = service.isAnswerCorrect(answeredQuestion);

        assertThat(isCorrect).isTrue();
    }

    private List<QuestionResponse> createQuestionList() {
        List<QuestionResponse> questions = new ArrayList<>();
        QuestionResponse question = new QuestionResponse();
        question.setQuestion("question");
        question.setAnswers(List.of("answer","answer","answer","answer"));
        question.setType(QuestionType.MULTIPLE);
        question.setDifficulty("difficulty");
        question.setCategory("category");
        questions.add(question);
        return questions;
    }

    private TriviaApiResponse createApiResponse() {

        TriviaApiResponse response = new TriviaApiResponse();
        response.setResponseCode(0);
        response.setResults(List.of(getTriviaResult()));

        return response;
    }

    private TriviaResult getTriviaResult() {
        TriviaResult result = new TriviaResult();
        result.setQuestion("question");
        result.setIncorrectAnswers(List.of("incanswer","incanswer","incanswer"));
        result.setType(QuestionType.MULTIPLE);
        result.setDifficulty("difficulty");
        result.setCategory("category");
        result.setCorrectAnswer("answer");
        return result;
    }
}