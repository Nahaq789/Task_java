package com.taskapp.app.API.CQRS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.GenericTypeResolver;

import java.util.HashMap;
import java.util.Map;

public class Registry {
    private Map<Class<? extends ICommand>, CommandProvider> commandProviderMap = new HashMap<>();
    private Map<Class<? extends IQuery>, QueryProvider> queryProviderMap = new HashMap<>();

    @Autowired
    public Registry(ApplicationContext applicationContext) {
        String[] commandNames = applicationContext.getBeanNamesForType(ICommandHandler.class);
        for (String name : commandNames) {
            registerCommand(applicationContext, name);
        }
        String[] queryNames = applicationContext.getBeanNamesForType(IQueryHandler.class);
        for (String name : queryNames) {
            registerQuery(applicationContext, name);
        }
    }

    public void registerCommand(ApplicationContext applicationContext, String name) {
        Class<ICommandHandler<?, ?>> handlerClass = (Class<ICommandHandler<?,?>>) applicationContext.getType(name);
        Class<?>[] generics = GenericTypeResolver.resolveTypeArguments(handlerClass, ICommandHandler.class);
        Class<? extends ICommand> commandType = (Class<? extends ICommand>) generics[1];
        commandProviderMap.put(commandType, new CommandProvider(applicationContext, handlerClass));
    }

    public void registerQuery(ApplicationContext applicationContext, String name) {
        Class<IQueryHandler<?, ?>> handlerClass = (Class<IQueryHandler<?,?>>) applicationContext.getType(name);
        Class<?>[] generics = GenericTypeResolver.resolveTypeArguments(handlerClass, IQueryHandler.class);
        Class<? extends IQuery> queryType = (Class<? extends IQuery>) generics[1];
        queryProviderMap.put(queryType, new QueryProvider(applicationContext, handlerClass));
    }

    @SuppressWarnings("unchecked")
    public <R, C extends ICommand<R>> ICommandHandler<R, C> getCommand(Class<C> commandClass) {
        return commandProviderMap.get(commandClass).get();
    }

    @SuppressWarnings("unchecked")
    public <R, C extends IQuery<R>> IQueryHandler<R, C> getQuery(Class<C> commandClass) {
        return queryProviderMap.get(commandClass).get();
    }
}
