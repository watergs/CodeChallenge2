package com.telepathylabs.codechallenge2.client.impl;

import com.telepathylabs.codechallenge2.client.ClientOperations;
import com.telepathylabs.codechallenge2.handler.impl.EvaluateInfixExpressionHandler;
import com.telepathylabs.codechallenge2.handler.impl.InfixExpressionToBinaryTreeHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
public class ClientOperationsImpl implements ClientOperations {

    @Autowired
    private EvaluateInfixExpressionHandler evaluateInfixExpressionHandler;

    @Autowired
    private InfixExpressionToBinaryTreeHandler infixExpressionToBinaryTreeHandler;

    @Override
    @ShellMethod(value = "Evaluate infix expression. The infix input can be provided by adding -I " +
            "*expression* or --infix *expression*. Don't include space in input.")
    public String evaluateInfixExpression(@ShellOption({"-I", "--infix"})String expression) {
        return evaluateInfixExpressionHandler.handle(expression);
    }

    @Override
    @ShellMethod(value = "Print out the tree. The infix input can be provided by adding -I " +
            "*expression* or --infix *expression*. Don't include space in input.")
    public String infixExpressionToBinaryTree(@ShellOption({"-I", "--infix"})String expression) {
        return infixExpressionToBinaryTreeHandler.handle(expression);
    }
}
