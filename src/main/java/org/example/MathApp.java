package org.example;

import org.example.service.strategy.CommandStrategy;
import org.example.service.strategy.handler.CommandHandler;

import java.util.Scanner;

public class MathApp {
    private final CommandStrategy commandStrategy;

    public MathApp(CommandStrategy commandStrategy) {
        this.commandStrategy = commandStrategy;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter command: ");
            String command = scanner.nextLine();
            CommandHandler commandHandler = commandStrategy.get(command);
            commandHandler.handle();
        }
    }
}
