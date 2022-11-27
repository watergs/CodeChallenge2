package com.telepathylabs.codechallenge2.executor.impl;

import com.telepathylabs.codechallenge2.common.model.Node;
import com.telepathylabs.codechallenge2.exception.InvalidExpression;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class OperationsExecutorImplTest {

    @InjectMocks
    @Spy
    private OperationsExecutorImpl spy;

    @BeforeMethod
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testEvaluateInfixExpression() throws InvalidExpression {
        int expected = -13;
        int actual = spy.evaluateInfixExpression("((15÷(7−(1+1)))×-3)−(2+(1+1))");

        Assert.assertEquals(actual, expected, "Evaluation failed");
    }

    @Test
    public void testBuildBinaryTreeNodesFromInfix() throws InvalidExpression {
        Node expected = new Node("5");
        Node actual = spy.buildBinaryTreeNodesFromInfix("5");

        Assert.assertEquals(actual.getData(), expected.getData(), "Data doesn't match");
    }
}
