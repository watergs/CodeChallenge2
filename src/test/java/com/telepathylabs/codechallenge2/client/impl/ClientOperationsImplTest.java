package com.telepathylabs.codechallenge2.client.impl;

import com.telepathylabs.codechallenge2.handler.impl.EvaluateInfixExpressionHandler;
import com.telepathylabs.codechallenge2.handler.impl.InfixExpressionToBinaryTreeHandler;
import org.mockito.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ClientOperationsImplTest {

    @InjectMocks
    @Spy
    private ClientOperationsImpl spy;

    @Mock
    private EvaluateInfixExpressionHandler evaluateInfixExpressionHandler;

    @Mock
    private InfixExpressionToBinaryTreeHandler infixExpressionToBinaryTreeHandler;

    @BeforeMethod
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testEvaluateInfixExpression() {
        String dummyResponse = "test";
        Mockito.when(evaluateInfixExpressionHandler.handle(Mockito.anyString())).thenReturn(dummyResponse);
        String actualResponse = spy.evaluateInfixExpression("Test");

        Assert.assertEquals(actualResponse, dummyResponse, "Response doesn't match");
    }

    @Test
    public void testInfixExpressionToBinaryTree() {
        String dummyResponse = "test";
        Mockito.when(infixExpressionToBinaryTreeHandler.handle(Mockito.anyString())).thenReturn(dummyResponse);
        String actualResponse = spy.infixExpressionToBinaryTree("Test");

        Assert.assertEquals(actualResponse, dummyResponse, "Response doesn't match");
    }
}
