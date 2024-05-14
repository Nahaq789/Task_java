package com.taskapp.app.API.Command.Event;

import com.taskapp.app.Domain.Model.Event.IDomainEvent;

public interface IDomainEventHandler<T extends IDomainEvent> {
    void Handle(T event);
}
