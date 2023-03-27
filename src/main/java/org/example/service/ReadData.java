package org.example.service;

import org.example.model.Equation;

import java.util.Scanner;

public class ReadData {
    public Equation readEquation() {
        Scanner input = new Scanner(System.in);
        System.out.print("Введіть математичне рівняння: ");
        Equation equation = new Equation();
        equation.setEquationValue(input.nextLine());
        return equation;
    }
}
