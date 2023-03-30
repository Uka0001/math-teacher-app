package org.example.service.strategy.handler.impl;

import java.util.List;
import java.util.Scanner;
import org.example.dao.EquationDao;
import org.example.dao.impl.EquationDaoImpl;
import org.example.service.strategy.handler.CommandHandler;

public class GetByRootNumber implements CommandHandler {
    private EquationDao equationDao = new EquationDaoImpl();
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void handle() {
        System.out.println("Enter number of roots to find an equation in database: ");
        int number = scanner.nextInt();
        List<String> equationsByNumberOfRoot = equationDao.getEquationsByRootNumber(number);
        System.out.println("Your equations are:");
        equationsByNumberOfRoot.forEach(System.out::println);
    }
}
