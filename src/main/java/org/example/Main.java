package org.example;

import org.example.dao.impl.EquationDaoImpl;
import org.example.model.Equation;
import org.example.service.strategy.CommandStrategyImpl;

import javax.script.ScriptException;

public class Main {
    public static void main( String[] args ) throws ScriptException {
        MathApp mathApp = new MathApp(new CommandStrategyImpl());
        mathApp.run();
    }
}
