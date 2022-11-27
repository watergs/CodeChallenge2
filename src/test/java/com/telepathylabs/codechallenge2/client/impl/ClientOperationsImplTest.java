package com.telepathylabs.codechallenge2.client.impl;

import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ClientOperationsImplTest {

    @InjectMocks
    @Spy
    private ClientOperationsImpl spy;

    @BeforeMethod
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testEvaluateInfixExpression() {
        String dummyResponse = "test";
        Mockito.when(spy.evaluateInfixExpression(Mockito.anyString())).thenReturn(dummyResponse);
        String actualResponse = spy.evaluateInfixExpression("Test");

        Assert.assertEquals(actualResponse, dummyResponse, "Response doesn't match");
    }
}
