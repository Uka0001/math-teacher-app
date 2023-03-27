package org.example.service.impl;

import org.example.service.ValidationOfEquation;

public class ValidationOfEquationImpl implements ValidationOfEquation {
    @Override
    public boolean checkBrackets(String expression) {
        if (expression.isEmpty() | !(expression.contains("(") && expression.contains(")"))) {
            return true;
        }
        int countOpen = (int) expression.chars().filter((i) -> i == '(').count();
        int countClosed = (int) expression.chars().filter((i) -> i == ')').count();
        int[] index = new int[2];
        char[] charArr = expression.toCharArray();
        if (countOpen == countClosed) {
            for (int i = 0; i < charArr.length; i++) {
                if (charArr[i] == '(') {
                    index[0] = i;
                }
                if (charArr[i] == ')') {
                    index[1] = i;
                }
            }
            return index[1] > index[0];

        }
        return false;
    }

    @Override
    public boolean checkSyntax(String expression) {
        char[] operatorsExceptMinus = {'+', '*', '/', '='};
        char[] chars = expression.toCharArray();
        if (contains(operatorsExceptMinus, chars[0])) {
            return false;
        }
        for (int i = 1; i < chars.length; i++) {
            if (contains(operatorsExceptMinus, chars[i]) && contains(operatorsExceptMinus, chars[i-1])) {
                return false;
            }
        }
        return true;
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
