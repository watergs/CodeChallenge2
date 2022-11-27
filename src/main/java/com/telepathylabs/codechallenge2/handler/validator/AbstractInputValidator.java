package com.telepathylabs.codechallenge2.handler.validator;

public abstract class AbstractInputValidator {

    private final String REGEX_FOR_INFIX_EXPRESSION = "[0-9()+-/*−×÷]*";
    private final char OPEN_ROUND_BRACKET = '(';
    private final char CLOSE_ROUND_BRACKET = ')';

    protected final boolean containsValidCharactersOnly(String input) {
        return input.matches(REGEX_FOR_INFIX_EXPRESSION);
    }

    protected final boolean isExpressionClosedProperly(String input) {
        if(input.contains(String.valueOf(OPEN_ROUND_BRACKET)) || input.contains(String.valueOf(CLOSE_ROUND_BRACKET))) {
            int openBracesCount = 0;
            int closeBracesCount = 0;
            for(int index = 0; index < input.length(); index++) {
                if(input.charAt(index) == OPEN_ROUND_BRACKET) {
                    openBracesCount++;
                }
                if(input.charAt(index) == CLOSE_ROUND_BRACKET) {
                    closeBracesCount++;
                }
            }
            return openBracesCount == closeBracesCount;
        }
        return true;
    }
}
