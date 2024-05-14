package com.taskapp.app.API.CQRS;

import org.springframework.stereotype.Component;

@Component
public class Bus implements IBus {
    private final Registry _registry;

    public Bus(Registry registry) {
        this._registry = registry;
    }

    @Override
    public <R, C extends ICommand<R>> R executeCommand(C command) {
        @SuppressWarnings("unchecked")
        ICommandHandler<R, C> commandHandler = (ICommandHandler<R, C>) _registry.getCommand(command.getClass());
        return commandHandler.Handle(command);
    }

    @Override
    public <R, Q extends IQuery<R>> R executeQuery(Q query) {
        @SuppressWarnings("unchecked")
        IQueryHandler<R, Q> queryHandler = (IQueryHandler<R, Q>) _registry.getQuery(query.getClass());
        return queryHandler.Handle(query);
    }
}
