package com.taskapp.app.API.Controller;

import java.util.List;
import java.util.UUID;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.taskapp.app.API.CQRS.IBus;
import com.taskapp.app.API.Command.CreateTaskCommand;
import com.taskapp.app.API.Command.GetAllTaskItemQuery;
import com.taskapp.app.API.Dto.TaskItemDto;
import com.taskapp.app.Domain.Model.Event.CreateTaskDomainEvent;

@RestController
public class TaskController {
    private final IBus _bus;
    private final ApplicationEventPublisher _applicationEventPublisher;

    public TaskController(IBus bus, ApplicationEventPublisher applicationEventPublisher) {
        this._bus = bus;
        this._applicationEventPublisher = applicationEventPublisher;
    }

    @GetMapping(value = "/api/v1/task/all")
    public ResponseEntity<List<TaskItemDto>> GetAllTaskItem() {
        GetAllTaskItemQuery query = new GetAllTaskItemQuery();
        List<TaskItemDto> result = _bus.executeQuery(query);

        return ResponseEntity.ok(result);
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
