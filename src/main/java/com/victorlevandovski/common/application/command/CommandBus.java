package com.victorlevandovski.common.application.command;

public interface CommandBus {

    <H extends CommandHandler> void subscribe(Class<? extends Command> commandClass, H commandHandler);

    <C extends Command, R extends CommandResult> void handle(C command, R commandResult);
}
