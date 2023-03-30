package org.example.service.impl;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import org.example.service.EquationValidator;

public class EquationValidatorImpl implements EquationValidator {
    public static final int FIRST_CHAR = 0;
    public static final String ROOT_VARIABLE = "x";
    public static final String EQUAL_SIGN = "=";
    public static final int OPEN_BRACKET_INDEX = 0;
    public static final int CLOSED_BRACKET_INDEX = 1;

    @Override
    public boolean checkBrackets(String equation) {
        if (equation.isEmpty() | !(equation.contains("(") && equation.contains(")"))) {
            return true;
        }
        int countOpen = (int) equation.chars().filter((i) -> i == '(').count();
        int countClosed = (int) equation.chars().filter((i) -> i == ')').count();
        int[] bracketIndexes = new int[2];
        char[] charArr = equation.toCharArray();
        if (countOpen == countClosed) {
            for (int i = 0; i < charArr.length; i++) {
                if (charArr[i] == '(') {
                    bracketIndexes[OPEN_BRACKET_INDEX] = i;
                }
                if (charArr[i] == ')') {
                    bracketIndexes[CLOSED_BRACKET_INDEX] = i;
                }
            }
            return bracketIndexes[CLOSED_BRACKET_INDEX] > bracketIndexes[OPEN_BRACKET_INDEX];

        }
        return false;
    }

    @Override
    public boolean checkSyntax(String equation) {
        char[] operatorsExceptMinus = {'+', '*', '/', '='};
        char[] chars = equation.toCharArray();
        if (contains(operatorsExceptMinus, chars[FIRST_CHAR])) {
            return false;
        }
        for (int i = 1; i < chars.length; i++) {
            if (contains(operatorsExceptMinus, chars[i])
                    && contains(operatorsExceptMinus, chars[i - 1])) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean checkRoot(String equation, Long root) throws ScriptException {
        boolean result = false;
        if (equation.contains(ROOT_VARIABLE)) {
            String expressionWithRoot = equation.replaceAll(ROOT_VARIABLE, String.valueOf(root));
            String[] expressions = expressionWithRoot.split(EQUAL_SIGN);
            ScriptEngineManager mgr = new ScriptEngineManager();
            ScriptEngine engine = mgr.getEngineByName("graal.js");
            result = engine.eval(expressions[0]).equals(engine.eval(expressions[1]));
        }
        return result;
    }

    public static boolean contains(char[] array, char item) {
        for (char element : array) {
            if (element == item) {
                return true;
            }
        }
        return false;
    }
}
