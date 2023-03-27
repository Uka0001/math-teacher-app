package org.example.service.strategy;

import org.example.service.strategy.handler.CommandHandler;

public interface CommandStrategy {
  CommandHandler get(String command);
}
