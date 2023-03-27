package org.example.service;

//import java.util.Scanner;

public class InputEquation {
//    public static void main(String[] args) {
//        Scanner input = new Scanner(System.in);
//        System.out.print("Введіть математичне рівняння: ");
//        String equation = input.nextLine();
//        if (!isValidEquation(equation)) {
//            System.out.println("Введене рівняння містить помилки.");
//            return;
//        }
//        System.out.print("Введіть значення x: ");
//        double x = input.nextDouble();
//        if (!isValidExpression(equation, x)) {
//            System.out.println("Введений вираз містить помилки.");
//            return;
//        }
//        double result = evaluateExpression(equation, x);
//        System.out.println("x = " + x + ", " + equation + " => " + result);
//    }
//
//    private static boolean isValidEquation(String equation) {
//        int numOpenParentheses = 0;
//        int numCloseParentheses = 0;
//        for (int i = 0; i < equation.length(); i++) {
//            char c = equation.charAt(i);
//            if (c == '(') {
//                numOpenParentheses++;
//            } else if (c == ')') {
//                numCloseParentheses++;
//            }
//            if (numCloseParentheses > numOpenParentheses) {
//                return false;
//            }
//        }
//        return numOpenParentheses == numCloseParentheses;
//    }
//
//    private static boolean isValidExpression(String equation, double x) {
//        String[] tokens = equation.split("(?=[-+*/()])|(?<=[-+*/][-+*/])");
//        for (int i = 0; i < tokens.length; i++) {
//            String token = tokens[i];
//            if (token.matches("^([+-]?\\d*\\.?\\d+|x)$")) {
//                continue;
//            }
//            if (token.equals("(") || token.equals(")")) {
//                continue;
//            }
//            if (i == 0 || i == tokens.length - 1) {
//                return false;
//            }
//            String prevToken = tokens[i - 1];
//            String nextToken = tokens[i + 1];
//            if (prevToken.equals("(") || nextToken.equals(")")) {
//                continue;
//            }
//            if (!prevToken.matches("^([+-]?\\d*\\.?\\d+|x)$") || !nextToken.matches("^([+-]?\\d*\\.?\\d+|x)$")) {
//                return false;
//            }
//        }
//        return true;
//    }
//
//    private static double evaluateExpression(String equation, double x) {
//        equation = equation.replaceAll("x", Double.toString(x));
//        return eval(equation);
//    }
//
//    private static double eval(String expression) {
//        expression = expression.replaceAll("\\s", "");
//        int numOpenParentheses = 0;
//        int numCloseParentheses = 0;
//        int index = -1;
//        for (int i = 0; i < expression.length(); i++) {
//            char c = expression.charAt(i);
//            if (c == '(') {
//                numOpenParentheses++;
//            } else if (c == ')') {
//                numCloseParentheses++;
//            }
//            if (numOpenParentheses > numCloseParentheses) {
//                continue;
//            }
//            if (c == '+' || c == '-') {
//                index = i;
//                break;
//            }
//        }
//        if (index == -1) {
//            index = expression.length();
//        }
//        String leftOperand = expression.substring(0, index);
//        String rightOperand = expression.substring(index);
//        if (leftOperand.startsWith("(") && leftOperand.endsWith(")")) {
//            leftOperand = leftOperand.substring(1, leftOperand.length() - 1);
//        }
//        if (rightOperand.startsWith("(") && rightOperand.endsWith(")")) {
//            rightOperand = rightOperand.substring(1, rightOperand.length() - 1);
//        }
//        if (leftOperand.equals("")) {
//            return eval(rightOperand);
//        }
//        if (rightOperand.equals("")) {
//            return eval(leftOperand);
//        }
//        if (leftOperand.matches("^([+-]?\\d*\\.?\\d+)$") && rightOperand.matches("^([+-]?\\d*\\.?\\d+)$")) {
//            double leftValue = Double.parseDouble(leftOperand);
//            double rightValue = Double.parseDouble(rightOperand);
//            if (expression.contains("*")) {
//                return leftValue * rightValue;
//            } else if (expression.contains("/")) {
//                return leftValue / rightValue;
//            } else if (expression.contains("+")) {
//                return leftValue + rightValue;
//            } else if (expression.contains("-")) {
//                return leftValue - rightValue;
//            } else {
//                throw new IllegalArgumentException("Unsupported operator.");
//            }
//        } else {
//            int nestedExpressionIndex = -1;
//            for (int i = leftOperand.length() - 1; i >= 0; i--) {
//                char c = leftOperand.charAt(i);
//                if (c == '(') {
//                    nestedExpressionIndex = i;
//                    break;
//                } else if (c == ')') {
//                    int numClose = 1;
//                    int numOpen = 0;
//                    for (int j = i - 1; j >= 0; j--) {
//                        char c2 = leftOperand.charAt(j);
//                        if (c2 == '(') {
//                            numOpen--;
//                            if (numOpen < 0) {
//                                nestedExpressionIndex = j;
//                                break;
//                            }
//                        } else if (c2 == ')') {
//                            numClose++;
//                        }
//                    }
//                    if (nestedExpressionIndex != -1) {
//                        break;
//                    }
//                }
//            }
//            if (nestedExpressionIndex != -1) {
//                String nestedExpression = leftOperand.substring(nestedExpressionIndex + 1);
//                double nestedValue = eval(nestedExpression);
//                String newLeftOperand = leftOperand.substring(0, nestedExpressionIndex) + Double.toString(nestedValue);
//                String newExpression = newLeftOperand + rightOperand;
//                return Double.parseDouble(newExpression); //TODO
//            } else {
//                throw new IllegalArgumentException("Invalid expression format.");
//            }
//        }
//    }
}
