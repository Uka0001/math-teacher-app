package org.example.service.strategy.handler.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.script.ScriptException;
import org.example.dao.EquationDao;
import org.example.dao.RootDao;
import org.example.dao.impl.EquationDaoImpl;
import org.example.dao.impl.RootDaoImpl;
import org.example.model.Equation;
import org.example.model.Root;
import org.example.service.ValidationOfEquation;
import org.example.service.impl.ValidationOfEquationImpl;
import org.example.service.strategy.handler.CommandHandler;

public class AddEquationHandler implements CommandHandler {
    private EquationDao equationDao = new EquationDaoImpl();
    private ValidationOfEquation validation = new ValidationOfEquationImpl();
    private RootDao rootDao = new RootDaoImpl();
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void handle() throws ScriptException {
        while (true) {
            System.out.println("Enter equation to save: ");
            Equation equation = new Equation();
            equation.setEquationValue(scanner.next());
            String equationValue = equation.getEquationValue();
            if (!validation.checkBrackets(equationValue)) {
                System.out.println("You have unbalanced brackets "
                        + "in your equation: " + equationValue);
                break;
            }
            if (!validation.checkSyntax(equationValue)) {
                System.out.println("You have bad syntax in your"
                        + " equation: " + equationValue);
                break;
            }
            equationDao.add(equation);
            List<Root> rootList = new ArrayList<>();
            addRootToEquation(equation, rootList);
            equation.setRootList(rootList);
            equationDao.update(equation);
            System.out.printf("Your equation: %s was added to db",
                    equationValue);
            break;
        }
    }

    private void addRootToEquation(Equation equation, List<Root> rootList) throws ScriptException {
        System.out.println("Do you want to save root to previous "
                + "entered equation: (answer \"y\" or \"n\")");
        if (scanner.next().equalsIgnoreCase("y")) {
            System.out.println("Enter your root you want to add to db: ");
            Long rootValue = Long.valueOf(scanner.next());
            Root root = new Root();
            root.setEquationId(equation.getId());
            root.setEquation(equation);
            root.setRootValue(rootValue);
            validateRoot(equation, rootList, rootValue, root);
        } else {
            System.out.println("Continue app services");
        }
    }

    private void validateRoot(Equation equation,
                              List<Root> rootList,
                              Long rootValue,
                              Root root) throws ScriptException {
        if (validation.checkRoot(equation.getEquationValue(), rootValue)) {
            rootList.add(root);
            rootDao.add(root);
            System.out.printf("Your root: %s was added to equation: %s ",
                    root.getRootValue(), equation.getEquationValue());
            System.out.println(System.lineSeparator());
            addRootToEquation(equation, rootList);
        } else {
            System.out.println("Your root is wrong. Try to add another root");
            addRootToEquation(equation, rootList);
        }
    }
}
