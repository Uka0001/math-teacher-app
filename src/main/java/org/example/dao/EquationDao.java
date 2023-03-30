package org.example.dao;

import java.util.List;
import org.example.model.Equation;

public interface EquationDao {
    Equation add(Equation equation);

    List<String> getEquationsByRoot(Long root);

    List<String> getEquationsByRootNumber(int rootNumber);

    Equation update(Equation equation);
}
