package com.telepathylabs.codechallenge2.handler.impl;

import com.telepathylabs.codechallenge2.executor.OperationsExecutor;
import com.telepathylabs.codechallenge2.handler.AbstractInputHandler;
import com.telepathylabs.codechallenge2.handler.validator.impl.EvaluateInfixExpressionInputValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.telepathylabs.codechallenge2.common.utils.Constants.INVALID_EXPRESSION;
import static com.telepathylabs.codechallenge2.common.utils.Constants.NEXT_LINE;

@Component
@Slf4j
public class EvaluateInfixExpressionHandler extends AbstractInputHandler<String, String> {

    @Autowired
    private EvaluateInfixExpressionInputValidator validator;

    @Autowired
    private OperationsExecutor operationsExecutor;

    @Override
    protected String validateInput(String input) {
        return validator.validate(input);
    }

    @Override
    protected String doHandle(String input) {
        StringBuilder output = new StringBuilder();

        output.append(NEXT_LINE);
        try {
            output.append(operationsExecutor.evaluateInfixExpression(input));
        } catch (Exception exception) {
            log.error("Exception Found: ", exception);
            output.append(INVALID_EXPRESSION);
        }
        return output.toString();
    }
}
