package com.telepathylabs.codechallenge2.handler.impl;

import com.telepathylabs.codechallenge2.common.model.Node;
import com.telepathylabs.codechallenge2.common.utils.BinaryTreePrinter;
import com.telepathylabs.codechallenge2.executor.OperationsExecutor;
import com.telepathylabs.codechallenge2.handler.AbstractInputHandler;
import com.telepathylabs.codechallenge2.handler.validator.impl.InfixExpressionToBinaryTreeInputValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InfixExpressionToBinaryTreeHandler extends AbstractInputHandler<String, String> {

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
        Node rootNode = operationsExecutor.buildBinaryTreeNodesFromInfix(input);
        System.out.println();
        BinaryTreePrinter.printNode(rootNode);
        return "Successfully Printed.";
    }
}
