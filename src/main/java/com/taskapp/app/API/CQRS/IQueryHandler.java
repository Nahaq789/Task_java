package com.taskapp.app.API.CQRS;

public interface IQueryHandler<R, C extends IQuery<R>> {
    R Handle(C query);
}
