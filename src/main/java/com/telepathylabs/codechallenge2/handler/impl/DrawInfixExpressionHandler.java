package com.telepathylabs.codechallenge2.handler.impl;

import com.telepathylabs.codechallenge2.executor.OperationsExecutor;
import com.telepathylabs.codechallenge2.handler.AbstractInputHandler;
import com.telepathylabs.codechallenge2.handler.validator.impl.DrawInfixExpressionInputValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DrawInfixExpressionHandler extends AbstractInputHandler<String, String> {

    @Autowired
    private DrawInfixExpressionInputValidator drawInfixExpressionInputValidator;

    @Autowired
    private OperationsExecutor operationsExecutor;

    @Override
    protected String validateInput(String s) {
        return null;
    }

    @Override
    protected String doHandle(String s) {
        return null;
    }
}
