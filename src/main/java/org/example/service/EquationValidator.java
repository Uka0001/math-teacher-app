package org.example.service;

import javax.script.ScriptException;

public interface EquationValidator {
    boolean checkBrackets(String equation);

    boolean checkSyntax(String equation);

    boolean checkRoot(String equation, Long root) throws ScriptException;
}
