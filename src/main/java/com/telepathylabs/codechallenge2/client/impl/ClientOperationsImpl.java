package com.telepathylabs.codechallenge2.client.impl;

import com.telepathylabs.codechallenge2.client.ClientOperations;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
public class ClientOperationsImpl implements ClientOperations {

    @Override
    @ShellMethod(value = "Evaluate infix expression. The infix input can be provided by adding -I " +
            "*expression* or --infix *expression*. Don't include * in input.")
    public String evaluateInfixExpression(@ShellOption({"-I", "--infix"})String expression) {
        return expression;
    }

    @Override
    @ShellMethod(value = "Print out the tree. The infix input can be provided by adding -I " +
            "*expression* or --infix *expression*. Don't include * in input.")
    public String drawInfixExpression(@ShellOption({"-I", "--infix"})String expression) {
        return expression;
    }
}
