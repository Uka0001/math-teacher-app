package org.example.service.strategy.handler.impl;


import org.example.service.strategy.handler.CommandHandler;

public class ExitCommandHandler implements CommandHandler {
  @Override
  public void handle() {
    System.exit(0);
  }
}
