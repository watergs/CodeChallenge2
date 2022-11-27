package com.telepathylabs.codechallenge2.common.utils;

import com.telepathylabs.codechallenge2.common.model.Node;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BinaryTreePrinterTest {

    @InjectMocks
    @Spy
    private BinaryTreePrinter spy;

    @BeforeMethod
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testPrintNode() {
        Node node = createNode();
        spy.printNode(node);
        Mockito.verifyNoMoreInteractions(spy);
    }

    private Node createNode() {
        Node node = new Node("1");
        node.setRightNode(new Node("2"));
        node.setLeftNode(new Node("3"));

        return node;
    }
}
