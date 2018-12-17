package com.victorlevandovski.common.application.command;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unchecked")
public class SpringCommandBus implements CommandBus {

    private Map<Class<? extends Command>, CommandHandler> commandMap = new HashMap<>();

    public SpringCommandBus() {
        super();
    }

    @Override
    public <H extends CommandHandler> void subscribe(Class<? extends Command> commandClass, H commandHandler) {
        this.commandMap.put(commandClass, commandHandler);
    }

    @Override
    public <C extends Command, R extends CommandResult> void handle(C command, R commandResult) {
        this.commandMap.get(command.getClass()).handle(command, commandResult);
    }
}
