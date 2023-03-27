package org.example.service.strategy.handler.impl;

import org.example.dao.impl.EquationDaoImpl;
import org.example.model.Equation;
import org.example.service.strategy.handler.CommandHandler;

import java.util.Scanner;

public class GetByRootName implements CommandHandler {
    EquationDaoImpl equationDao = new EquationDaoImpl();
    Scanner scanner = new Scanner(System.in);

    @Override
    public void handle() {
        System.out.println("Enter number of roots to find an equation in database: ");
        String rootValue = scanner.next();
        Equation equationsByNumberOfRoot = equationDao.getEquationsByRoot(rootValue);
        System.out.printf("Your equation is: %s, by root value: %s",
                equationsByNumberOfRoot.getEquationValue(), rootValue);
    }
}
