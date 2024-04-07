package com.taskapp.app.API.CQRS;

import org.springframework.context.ApplicationContext;

public class CommandProvider <H extends ICommandHandler<?, ?>> {
    private final ApplicationContext _applicationContext;
    private final Class<H> _type;

    public CommandProvider(ApplicationContext applicationContext, Class<H> type) {
        this._applicationContext = applicationContext;
        this._type = type;
    }

    public H get() {
        return _applicationContext.getBean(_type);
    }
}
