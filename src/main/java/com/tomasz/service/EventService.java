package com.tomasz.service;

import com.tomasz.model.dto.Event;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class EventService {

    private final WebClient webClient;

    public EventService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://localhost:8090").build();
    }

    public List<Event> getEvents(){
        return (List<Event>) webClient.get().uri("/events");
    }
}
