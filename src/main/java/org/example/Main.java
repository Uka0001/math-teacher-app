package org.example;

import javax.script.ScriptException;
import org.example.service.strategy.CommandStrategyImpl;

public class Main {
    public static void main(String[] args) throws ScriptException {
        MathApp mathApp = new MathApp(new CommandStrategyImpl());
        mathApp.run();
    }
}
