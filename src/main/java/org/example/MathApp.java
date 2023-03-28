package org.example;

import java.util.Scanner;
import javax.script.ScriptException;
import org.example.service.strategy.CommandStrategy;
import org.example.service.strategy.handler.CommandHandler;

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
