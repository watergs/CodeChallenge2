package com.telepathylabs.codechallenge2.handler.impl;

import com.telepathylabs.codechallenge2.common.model.Node;
import com.telepathylabs.codechallenge2.common.utils.BinaryTreePrinter;
import com.telepathylabs.codechallenge2.exception.InvalidExpression;
import com.telepathylabs.codechallenge2.executor.OperationsExecutor;
import com.telepathylabs.codechallenge2.handler.AbstractInputHandler;
import com.telepathylabs.codechallenge2.handler.validator.impl.InfixExpressionToBinaryTreeInputValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.telepathylabs.codechallenge2.common.utils.Constants.NEXT_LINE;

@Component
public class InfixExpressionToBinaryTreeHandler extends AbstractInputHandler<String, String> {

    private static final String SUCCESSFULLY_PRINTED = "Successfully Printed.";

    @Autowired
    private InfixExpressionToBinaryTreeInputValidator validator;

    @Autowired
    private OperationsExecutor operationsExecutor;

    @Override
    protected String validateInput(String input) {
        return validator.validate(input);
    }

    @Override
    protected String doHandle(String input) {
        String output = NEXT_LINE + SUCCESSFULLY_PRINTED;
        Node rootNode = null;
        try {
            rootNode = operationsExecutor.buildBinaryTreeNodesFromInfix(input);
        } catch (InvalidExpression e) {
            output = NEXT_LINE + e.getMessage();
        }
        BinaryTreePrinter.printNode(rootNode);
        return output;
    }
}
