package com.telepathylabs.codechallenge2.common.utils;

import com.telepathylabs.codechallenge2.exception.IndivisibleException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ExpressionSolverUtils {

    public static int performOperations(int firstInt, int secondInt, char operation) {
        switch (operation) {
            case '+':
                return firstInt + secondInt;
            case '-':
            case '−':
                return secondInt - firstInt;
            case '*':
            case '×':
                return firstInt * secondInt;
            case '/':
            case '÷':
                if(firstInt == 0) {
                    log.error("Cannot divide by 0!");
                    throw new IndivisibleException("Cannot divide by 0!");
                }
                return secondInt/firstInt;
            case '^':
                return (int) Math.pow(secondInt, firstInt);
        }
        return 0;
    }

    public static int operatorPrecedence(char operator) {
        switch (operator)
        {
            case '+':
            case '-':
            case '−':
                return 1;
            case '*':
            case '/':
            case '×':
            case '÷':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    public static boolean isOperator(char character) {
        return character == '+' || character == '-' || character == '−'|| character == '*' || character == '×'
                || character == '/' || character == '÷' || character == '^';
    }

}
