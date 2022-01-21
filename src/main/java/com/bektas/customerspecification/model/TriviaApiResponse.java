package com.bektas.customerspecification.model;

import java.util.List;

public class TriviaApiResponse {
    private int responseCode;
    private List<TriviaResult> results;

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public List<TriviaResult> getResults() {
        return results;
    }

    public void setResults(List<TriviaResult> results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "TriviaApiResponse{" +
                "responseCode=" + responseCode +
                ", results=" + results +
                '}';
    }
}
