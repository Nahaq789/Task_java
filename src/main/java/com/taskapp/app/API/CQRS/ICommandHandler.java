package com.taskapp.app.API.CQRS;

public interface ICommandHandler<R, C extends ICommand<R>> {
    R Handle(C command);
}
