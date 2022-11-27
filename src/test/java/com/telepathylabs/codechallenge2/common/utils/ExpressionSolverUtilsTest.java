package com.telepathylabs.codechallenge2.common.utils;

import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExpressionSolverUtilsTest {

    @InjectMocks
    @Spy
    private ExpressionSolverUtils spy;

    @BeforeMethod
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testPerformOperations() {
        int a = 2;
        int b = 2;
        int expAdd = 4;
        int expMul = 4;
        int expSub = 0;
        int expDiv = 1;

        int actualAdd = spy.performOperations(a,b, '+');
        int actualMul = spy.performOperations(a,b, '*');
        int actualSub = spy.performOperations(a,b, '-');
        int actualDiv = spy.performOperations(a,b, '/');

        Assert.assertEquals(actualAdd, expAdd, "Addition doesn't match");
        Assert.assertEquals(actualMul, expMul, "Multiplication doesn't match");
        Assert.assertEquals(actualSub, expSub, "Subtraction doesn't match");
        Assert.assertEquals(actualDiv, expDiv, "Division doesn't match");
    }

    @Test
    public void testOperatorPrecedence() {
        int expected = 1;
        int actual = spy.operatorPrecedence('+');

        Assert.assertEquals(actual, expected, "Precedence doesn't match");
    }

    @Test
    public void testIsOperator() {
        char op = '+';
        Assert.assertTrue(spy.isOperator(op));
    }
}
