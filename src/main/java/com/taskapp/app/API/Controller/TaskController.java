package com.taskapp.app.API.Controller;

import com.taskapp.app.API.CQRS.IBus;
import com.taskapp.app.API.Command.CreateTaskCommand;
import com.taskapp.app.Domain.Model.TaskItem;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController {
    private final IBus _bus;
    @Autowired
    public TaskController(IBus bus) {
        this._bus = bus;
    }

    @PostMapping("/api/v1/task/CreateTask")
    public ResponseEntity<Long> CreateTask(
            @RequestBody CreateTaskCommand command) {
        return ResponseEntity.ok(_bus.executeCommand(command));
    }
}
