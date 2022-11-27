package com.telepathylabs.codechallenge2.handler.validator.impl;

import com.telepathylabs.codechallenge2.handler.validator.AbstractInputValidator;
import com.telepathylabs.codechallenge2.handler.validator.InputValidator;
import org.springframework.stereotype.Component;

import static com.telepathylabs.codechallenge2.common.utils.Constants.INVALID_EXPRESSION;
import static com.telepathylabs.codechallenge2.common.utils.Constants.NEXT_LINE;

@Component
public class InfixExpressionToBinaryTreeInputValidator extends AbstractInputValidator implements InputValidator<String, String>{

    @Override
    public String validate(String input) {
        if(containsValidCharactersOnly(input) && isExpressionClosedProperly(input)) {
            return null;
        }
        return NEXT_LINE + INVALID_EXPRESSION;
    }
}
