package com.victorlevandovski.common.application.command;

public interface CommandHandler<C extends Command, R extends CommandResult> {

     void handle(C command, R commandResult);
}
