package org.example.service.strategy.handler;

import javax.script.ScriptException;

public interface CommandHandler {
    void handle() throws ScriptException;
}
