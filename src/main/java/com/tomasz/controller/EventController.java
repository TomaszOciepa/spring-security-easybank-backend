package com.tomasz.controller;

import com.tomasz.model.dto.Event;
import com.tomasz.service.EventService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class EventController {

    private final EventService eventService;


    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/api/events")
    public Mono<Event> getEvents() {
        return eventService.getEvents();
    }

    @GetMapping("/api/test")
    public Mono<String> getTest() {
        return eventService.getTest();
    }
}
