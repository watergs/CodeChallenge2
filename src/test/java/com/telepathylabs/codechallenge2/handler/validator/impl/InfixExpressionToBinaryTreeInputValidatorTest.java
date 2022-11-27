package com.telepathylabs.codechallenge2.handler.validator.impl;

import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class InfixExpressionToBinaryTreeInputValidatorTest {

    @InjectMocks
    @Spy
    private InfixExpressionToBinaryTreeInputValidator spy;

    @BeforeMethod
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testValidate() {
        String inp = "((15÷(7−(1+1)))×-3)−(2+(1+1))";
        Assert.assertNull(spy.validate(inp));
    }
}
