package com.bektas.customerspecification.model;

import com.fasterxml.jackson.annotation.JsonValue;

public enum QuestionType {
    MULTIPLE("multiple"), BOOLEAN("boolean");

    private final String type;

    QuestionType(String type) {
        this.type = type;
    }

    @JsonValue
    @Override
    public String toString() {
        return type;
    }
}
