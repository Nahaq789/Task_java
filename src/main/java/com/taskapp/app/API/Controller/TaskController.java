package com.taskapp.app.API.Controller;

import com.taskapp.app.API.CQRS.IBus;
import com.taskapp.app.API.Command.CreateTaskCommand;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController {
    private final IBus _bus;

    public TaskController(IBus bus) {
        this._bus = bus;
    }

    @PostMapping(value = "/api/v1/task/CreateTask", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Long> CreateTask(
            @RequestBody CreateTaskCommand command) {
        return ResponseEntity.ok(_bus.executeCommand(command));
    }
}
