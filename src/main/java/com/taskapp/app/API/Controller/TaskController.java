package com.taskapp.app.API.Controller;

import com.taskapp.app.API.CQRS.IBus;
import com.taskapp.app.API.Command.CreateTaskCommand;
import com.taskapp.app.Domain.Model.Event.CreateTaskDomainEvent;
import java.util.UUID;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController {
    private final IBus _bus;
    private final ApplicationEventPublisher _applicationEventPublisher;

    public TaskController(IBus bus, ApplicationEventPublisher applicationEventPublisher) {
        this._bus = bus;
        this._applicationEventPublisher = applicationEventPublisher;
    }

    @PostMapping(value = "/api/v1/task/CreateTask", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> CreateTask(
            @RequestBody CreateTaskCommand command) {
        Long result = _bus.executeCommand(command);
        _applicationEventPublisher.publishEvent(new CreateTaskDomainEvent(
                UUID.randomUUID(),
                result,
                1));
        return ResponseEntity.ok("aaa");
    }
}
