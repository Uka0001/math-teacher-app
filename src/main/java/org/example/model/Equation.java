package org.example.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "equations")
public class Equation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "equation_value")
    private String equationValue;
    //    @OneToMany(mappedBy = "rootValue", fetch = FetchType.LAZY)
    @OneToMany
    private List<Root> rootList;

    public boolean checkBrackets(String equationValue) {
        if (equationValue.isEmpty() | !(equationValue.contains("(") && equationValue.contains(")"))) {
            return true;
        }
        int countOpen = (int) equationValue.chars().filter((i) -> i == '(').count();
        int countClosed = (int) equationValue.chars().filter((i) -> i == ')').count();
        int[] index = new int[2];
        char[] charArr = equationValue.toCharArray();
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
