package com.bektas.customerspecification.repository;

import com.bektas.customerspecification.model.TriviaResult;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TriviaRepository {

    private List<TriviaResult> results;

    public void setResults(List<TriviaResult> results) {
        this.results = results;
    }

    public List<TriviaResult> getResults() {
        return results;
    }
}
