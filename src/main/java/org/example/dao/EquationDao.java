package org.example.dao;

import java.util.List;
import org.example.model.Equation;

public interface EquationDao {
    Equation add(Equation equation);

    List<String> getEquationsByRoot(Long rootValue);

    List<String> getEquationsByNumberOfRoot(int number);

    Equation update(Equation equation);
}
