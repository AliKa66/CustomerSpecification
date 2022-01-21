package com.bektas.customerspecification.mapper;

import com.bektas.customerspecification.model.QuestionResponse;
import com.bektas.customerspecification.model.TriviaApiResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class TriviaApiResponseMapper {

    private final Random random;

    public TriviaApiResponseMapper() {
        random = new Random();
    }

    public List<QuestionResponse> toListOfQuestions(TriviaApiResponse response) {
        List<QuestionResponse> questions = new ArrayList<>();

        response.getResults().forEach(res -> {
            List<String> answers = new ArrayList<>(res.getIncorrectAnswers());
            addCorrectAnswerToARandomIndex(answers, res.getCorrectAnswer());

            QuestionResponse question = new QuestionResponse();
            question.setQuestion(res.getQuestion());
            question.setDifficulty(res.getDifficulty());
            question.setCategory(res.getCategory());
            question.setType(res.getType());
            question.setAnswers(answers);
            questions.add(question);
        });

        return questions;
    }

    private void addCorrectAnswerToARandomIndex(List<String> answers, String correctAnswer) {
        int size = answers.size();
        int randomIndex = random.nextInt(size == 1 ? size : size - 1);
        answers.add(randomIndex, correctAnswer);
    }
}
