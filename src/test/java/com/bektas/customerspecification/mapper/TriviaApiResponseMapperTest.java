package com.bektas.customerspecification.mapper;

import com.bektas.customerspecification.model.QuestionResponse;
import com.bektas.customerspecification.model.QuestionType;
import com.bektas.customerspecification.model.TriviaApiResponse;
import com.bektas.customerspecification.model.TriviaResult;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class TriviaApiResponseMapperTest {

    private TriviaApiResponseMapper mapper = new TriviaApiResponseMapper();
    private int numberOfResults = 5;
    private int totalAnswers = 4;

    @Test
    void toListOfQuestionsMapsCorrectly() {
        TriviaApiResponse response = getTriviaResponse();
        int index = 0;
        List<QuestionResponse> questionResponses = mapper.toListOfQuestions(response);


        assertThat(questionResponses).isNotEmpty();
        assertThat(questionResponses.size()).isEqualTo(response.getResults().size());
        assertThat(questionResponses.get(index).getQuestion())
                .isNotNull()
                .isEqualTo(response.getResults().get(index).getQuestion());
        assertThat(questionResponses.get(index).getCategory())
                .isNotNull()
                .isEqualTo(response.getResults().get(index).getCategory());

        assertThat(questionResponses.get(index).getAnswers()).isNotNull();
        assertThat(questionResponses.get(index).getAnswers().size()).isEqualTo(totalAnswers);
        assertThat(questionResponses.get(index).getDifficulty())
                .isNotNull()
                .isEqualTo(response.getResults().get(index).getDifficulty());

        assertThat(questionResponses.get(index).getType())
                .isNotNull()
                .isEqualTo(response.getResults().get(index).getType());
    }

    private TriviaApiResponse getTriviaResponse() {
        TriviaApiResponse response = new TriviaApiResponse();
        List<TriviaResult> results = getTriviaResults();
        response.setResults(results);
        response.setResponseCode(0);

        return response;
    }

    private List<TriviaResult> getTriviaResults() {
        List<TriviaResult> results = new ArrayList<>();
        for (int i = 0; i < numberOfResults; i++) {
            TriviaResult result = new TriviaResult();
            result.setCategory("category");
            result.setCorrectAnswer("answer");
            result.setQuestion("question");
            result.setDifficulty("difficulty");
            result.setType(QuestionType.MULTIPLE);
            List<String> incorrectAnswers = new ArrayList<>();
            for (int j = 0; j < totalAnswers - 1; j++) {
                incorrectAnswers.add("answer");
            }
            result.setIncorrectAnswers(incorrectAnswers);
            results.add(result);
        }

        return results;
    }
}