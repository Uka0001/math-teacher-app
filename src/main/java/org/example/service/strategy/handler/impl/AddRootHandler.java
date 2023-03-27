package org.example.service.strategy.handler.impl;

import org.example.dao.impl.RootDaoImpl;
import org.example.model.Root;
import org.example.service.strategy.handler.CommandHandler;

import java.util.Scanner;

public class AddRootHandler implements CommandHandler {
  RootDaoImpl rootDao = new RootDaoImpl();
  Scanner scanner = new Scanner(System.in);
  @Override
  public void handle() {
    System.out.println("Do you want to add root to your equation?(answer \"y\" or \"n\")");
    Root root = new Root();
    if (scanner.next().equalsIgnoreCase("y")) {
      System.out.println("Enter your root you want to add to db: )");
      root.setRootValue(Long.valueOf(scanner.next()));
      rootDao.add(root);
    } else {
      System.out.println("Your root was not added, you can try another command");
    }
    System.out.println("Your root was added");
  }
}
