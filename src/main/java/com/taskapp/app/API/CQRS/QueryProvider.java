package com.taskapp.app.API.CQRS;

import org.springframework.context.ApplicationContext;

public class QueryProvider<H extends IQueryHandler<?, ?>> {
    private final ApplicationContext _applicationContext;
    private final Class<H> _type;

    public QueryProvider(ApplicationContext applicationContext, Class<H> type) {
        this._applicationContext = applicationContext;
        this._type = type;
    }

    public H get() {
        return _applicationContext.getBean(_type);
    }
}
