package com.bektas.customerspecification;

import com.bektas.customerspecification.model.TriviaApiResponse;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class TriviaWebClient {
    private final WebClient client;

    public TriviaWebClient(WebClient.Builder builder) {
        client = builder
                .baseUrl("https://opentdb.com/api.php")
                .build();
    }

    public Mono<TriviaApiResponse> getQuestions(int amount) {
        return client
                .get()
                .uri("?amount={amount}", amount)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(TriviaApiResponse.class);
    }
}
