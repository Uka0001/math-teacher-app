package org.example.dao;

import org.example.model.Equation;

public interface EquationDao {
    Equation add(Equation equation);

    Equation getEquationsByRoot(String rootValue);

    Equation getEquationsByNumberOfRoot(int number);
}
