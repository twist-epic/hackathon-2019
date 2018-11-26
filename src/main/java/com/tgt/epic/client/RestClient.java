package com.tgt.epic.client;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.retry.Retry;
import java.time.Duration;


@Slf4j
@Component
public class RestClient {


    public ResponseEntity<String> postRequest(String baseUrl, String endpointUrl, Object requestObject){

        WebClient webClient = WebClient.create(baseUrl);

        ResponseEntity<String> quoteResponse = webClient.post().uri(endpointUrl)
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(requestObject), Object.class)
                .exchange()
                .flatMap(clientResponse -> {
                    if(clientResponse.statusCode().is5xxServerError() || clientResponse.statusCode().is4xxClientError()){
                        String errorMessage = "Http error:" + clientResponse.statusCode() + " while submitting request to endpoint: " + endpointUrl;
                        throw new RuntimeException(errorMessage);
                    }
                    return clientResponse.toEntity(String.class);
                })
                .retryWhen(Retry.anyOf(RuntimeException.class).retryMax(5).fixedBackoff(Duration.ofSeconds(5)))
                .block();
        return quoteResponse;
    }
}
