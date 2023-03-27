package org.example;

import org.example.service.strategy.CommandStrategy;
import org.example.service.strategy.handler.CommandHandler;

import javax.script.ScriptException;
import java.util.Scanner;

public class MathApp {
    private final CommandStrategy commandStrategy;

    public MathApp(CommandStrategy commandStrategy) {
        this.commandStrategy = commandStrategy;
    }

    public void run() throws ScriptException {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println(System.lineSeparator() + "Enter command: ");
            String command = scanner.next();
            CommandHandler commandHandler = commandStrategy.get(command);
            commandHandler.handle();
        }
    }
}
