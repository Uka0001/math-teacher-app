package org.example.service.strategy.handler.impl;

import org.example.dao.impl.EquationDaoImpl;
import org.example.model.Equation;
import org.example.service.strategy.handler.CommandHandler;

import java.util.List;
import java.util.Scanner;

public class GetByRootName implements CommandHandler {
    EquationDaoImpl equationDao = new EquationDaoImpl();
    Scanner scanner = new Scanner(System.in);

    @Override
    public void handle() {
        System.out.println("Enter value of root to find an equations with this root in database: ");
        String rootValue = scanner.next();
        List<String> equationsListByRootValue = equationDao.getEquationsByRoot(Long.valueOf(rootValue));
        System.out.println("Your equations are:");
        equationsListByRootValue.forEach(System.out::println);
    }
}
