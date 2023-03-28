package org.example.dao;

import org.example.model.Equation;

import java.util.List;

public interface EquationDao {
    Equation add(Equation equation);

    List<String> getEquationsByRoot(Long rootValue);

    List<String> getEquationsByNumberOfRoot(int number);

    Equation update(Equation equation);
}
