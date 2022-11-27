package com.telepathylabs.codechallenge2.handler.impl;

import com.telepathylabs.codechallenge2.common.model.Node;
import com.telepathylabs.codechallenge2.executor.OperationsExecutor;
import com.telepathylabs.codechallenge2.handler.validator.impl.InfixExpressionToBinaryTreeInputValidator;
import org.mockito.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class InfixExpressionToBinaryTreeHandlerTest {

    @InjectMocks
    @Spy
    private InfixExpressionToBinaryTreeHandler spy;

    @Mock
    private InfixExpressionToBinaryTreeInputValidator validator;

    @Mock
    private OperationsExecutor operationsExecutor;

    @BeforeMethod
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testValidateInput() {
        String test = "test";
        Mockito.when(validator.validate(Mockito.anyString())).thenReturn(test);
        String actual = spy.validateInput(Mockito.anyString());

        Assert.assertEquals(actual, test, "Validation doesn't match");
    }

    @Test
    public void testDoHandle() throws Exception {
        Node exp = new Node("5");
        Mockito.when(operationsExecutor.buildBinaryTreeNodesFromInfix(Mockito.anyString())).thenReturn(exp);
        String actual = spy.doHandle(Mockito.anyString());
        Assert.assertEquals(actual, "\n" + "Successfully Printed.", "DoHandle doesn't work");
    }
}
