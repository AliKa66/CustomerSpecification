package com.bektas.customerspecification.model;

public class AnsweredQuestion {
    private String question;
    private String answer;

    public AnsweredQuestion() {
    }

    public AnsweredQuestion(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
