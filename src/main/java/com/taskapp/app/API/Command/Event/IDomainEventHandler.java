package com.taskapp.app.API.Command.Event;

import com.taskapp.app.Domain.Model.Event.IDomainEvent;
import org.springframework.context.event.EventListener;

public interface IDomainEventHandler <T extends IDomainEvent> {
    void Handle(T event);
}
