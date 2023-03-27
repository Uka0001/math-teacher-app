package org.example.service.strategy.handler.impl;

import org.example.dao.EquationDao;
import org.example.dao.RootDao;
import org.example.dao.impl.EquationDaoImpl;
import org.example.dao.impl.RootDaoImpl;
import org.example.model.Equation;
import org.example.model.Root;
import org.example.service.strategy.handler.CommandHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddEquationHandler implements CommandHandler {
  EquationDao equationDao = new EquationDaoImpl();
  RootDao rootDao = new RootDaoImpl();
  Scanner scanner = new Scanner(System.in);
  @Override
  public void handle() {
    while (true) {
      System.out.println("Enter equation to save: ");
      Equation equation = new Equation();
      equation.setEquationValue(scanner.nextLine());
      List<Root> rootList = new ArrayList<>();
      addRootToEquation(equation, rootList);
      equation.setRootList(rootList);
      equationDao.add(equation);
      System.out.printf("Your equation: %s was added to db", equation.getEquationValue());
      break;
    }
  }

  private void addRootToEquation(Equation equation, List<Root> rootList) {
    System.out.println("Do you want to save root to previous entered equation: (answer \"y\" or \"n\")");
    if (scanner.next().toLowerCase().equals("y")) {
      System.out.println("Enter your root you want to add to db: ");
      Long rootValue = scanner.nextLong();
      Root root = new Root();
      root.setRootValue(rootValue);
      rootDao.add(root);
      rootList.add(root);
      System.out.printf("Your root: %s was added to equation: %s ", root.getRootValue(), equation.getEquationValue());
      System.out.println(System.lineSeparator());
      addRootToEquation(equation, rootList);
    } else {
      System.out.println("Continue app services");
    }
  }
}
