package org.example.service;

import javax.script.ScriptException;

public interface ValidationOfEquation {
    boolean checkBrackets(String expression);

    boolean checkSyntax(String expression);

    boolean checkRoot(String expression, Long rootValue) throws ScriptException;
}
