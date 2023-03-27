package org.example.service.strategy.handler.impl;

import org.example.model.Command;
import org.example.service.strategy.handler.CommandHandler;

import java.util.Arrays;

public class HelpCommandHandler implements CommandHandler {
  @Override
  public void handle() {
    Arrays.stream(Command.values())
        .forEach((command) -> System.out.println(
            command.name().toLowerCase() + " -> " + command.getDescription()
        ));
  }
}
