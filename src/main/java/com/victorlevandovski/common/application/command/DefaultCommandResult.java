package com.victorlevandovski.common.application.command;

public class DefaultCommandResult implements CommandResult {

    private boolean result;

    public DefaultCommandResult() {
        super();
    }

    public boolean result() {
        return this.result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }
}
