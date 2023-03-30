package org.example.service.impl;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.script.ScriptException;

class ValidationOfEquationImplTest {
    private List<String> validStringsList;
    private List<String> notValidStringsList;
    private EquationValidatorImpl validation;

    @BeforeEach
    void setUp() {
        validation = new EquationValidatorImpl();
        validStringsList = List.of(
                "(2*x)+5=17",
                "-1.3*(5/x)=1.2",
                "2*x+(1-3)=10",
                "2*x+((5+х)+5)=10",
                "17=2*(x+5)");
        notValidStringsList = List.of(
                "((2/*x)+5=17",
                "-1.3*(5/+x))=1.2",
                "2*/x+((1-3)=10",
                "2*-x+(((5++х)+5)=10",
                "17=2/*(x+5))");

    }

    @Test
    void checkBrackets_validEquation_ok() {
        for (String string : validStringsList) {
            assertTrue(validation.checkBrackets(string),
                    "Brackets should be validated and return"
                            + " true for equation: " + string);
        }

    }

    @Test
    void checkBrackets_inValidEquation_notOk() {
        for (String string : notValidStringsList) {
            assertFalse(validation.checkBrackets(string),
                    "Brackets should be not validated and return "
                            + "false for equation: " + string);
        }

    }

    @Test
    void checkSyntax_validEquation_ok() {
        for (String string : validStringsList) {
            assertTrue(validation.checkSyntax(string),
                    "Syntax should be validated and return "
                            + " true for equation: " + string);
        }
    }

    @Test
    void checkSyntax_invalidEquation_notOk() {
        for (String string : notValidStringsList) {
            assertFalse(validation.checkSyntax(string),
                    "Syntax should be not validated and return "
                            + "false for equation: + string)");
        }
    }

    @Test
    void checkRoot_validEquation_ok() throws ScriptException {
        assertTrue(validation.checkRoot("(2*x)+5=17", 6L),
                "Root should be right for equation");
        assertTrue(validation.checkRoot("-1*(5+x)=-12", 7L),
                "Root should be right for equation");
        assertTrue(validation.checkRoot("2*x+(1-3)=10", 6L),
                "Root should be right for equation");
        assertTrue(validation.checkRoot("(2*x)+10=20", 5L),
                "Root should be right for equation");
        assertTrue(validation.checkRoot("20=2*(x+5)", 5L),
                "Root should be right for equation");
    }

    @Test
    void checkRoot_invalidEquation_notOk() throws ScriptException {
        assertFalse(validation.checkRoot("(2*x)+5=17", 7L),
                "Root should be right for equation");
        assertFalse(validation.checkRoot("-1*(5+x)=-12", 6L),
                "Root should be right for equation");
        assertFalse(validation.checkRoot("2*x+(1-3)=10", 8L),
                "Root should be right for equation");
        assertFalse(validation.checkRoot("(2*x)+10=20", 9L),
                "Root should be right for equation");
        assertFalse(validation.checkRoot("20=2*(x+5)", 10L),
                "Root should be right for equation");
    }
}