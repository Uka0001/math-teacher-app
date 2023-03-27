package org.example;

import org.example.dao.impl.EquationDaoImpl;
import org.example.model.Equation;
import org.example.service.ReadData;

public class App {
    private static ReadData readData = new ReadData();
    private static EquationDaoImpl equationDao = new EquationDaoImpl();
    public static void main( String[] args ) {
        System.out.println( "Welcome User!" );
        Equation equation = readData.readEquation();
        equationDao.add(equation);
    }
}
