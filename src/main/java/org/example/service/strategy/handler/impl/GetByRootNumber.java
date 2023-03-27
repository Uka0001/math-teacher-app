package org.example.service.strategy.handler.impl;

import org.example.dao.impl.EquationDaoImpl;
import org.example.model.Equation;
import org.example.service.strategy.handler.CommandHandler;
import java.util.Scanner;

public class GetByRootNumber implements CommandHandler {
  EquationDaoImpl equationDao = new EquationDaoImpl();
  Scanner scanner = new Scanner(System.in);

  @Override
  public void handle() {
    System.out.println("Enter number of roots to find an equation in database: ");
    int number = scanner.nextInt();
    Equation equationsByNumberOfRoot = equationDao.getEquationsByNumberOfRoot(number);
    System.out.printf("Your equation is: %s, by roots number: %s",
            equationsByNumberOfRoot.getEquationValue(), number);
  }
}
