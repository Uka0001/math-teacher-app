package org.example.service.strategy.handler.impl;

import org.example.dao.EquationDao;
import org.example.dao.impl.EquationDaoImpl;
import org.example.model.Equation;
import org.example.service.strategy.handler.CommandHandler;

import java.util.List;
import java.util.Scanner;

public class GetByRootNumber implements CommandHandler {
  EquationDao equationDao = new EquationDaoImpl();
  Scanner scanner = new Scanner(System.in);

  @Override
  public void handle() {
    System.out.println("Enter number of roots to find an equation in database: ");
    int number = scanner.nextInt();
    List<String> equationsByNumberOfRoot = equationDao.getEquationsByNumberOfRoot(number);
    System.out.println("Your equations are:");
    equationsByNumberOfRoot.forEach(System.out::println);
  }
}
