package com.taskapp.app.API.CQRS;

public interface IBus {
    <R, C extends ICommand<R>> R executeCommand(C command);
    <R, Q extends IQuery<R>> R executeQuery(Q query);
}
