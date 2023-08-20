package com.tomasz.service;

import com.tomasz.model.dto.Event;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class EventService {

    private final WebClient webClient;

    public EventService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://localhost:4200").build();
    }

    public Mono<Event> getEvents(){
        return  webClient.get()
                .uri("/events")
                .retrieve()
                .bodyToMono(Event.class);
    }

    public Mono<String> getTest(){
        return webClient
                .get()
                .uri("/test").retrieve().bodyToMono(String.class);
    }
}
