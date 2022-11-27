package com.telepathylabs.codechallenge2.executor;

import com.telepathylabs.codechallenge2.common.model.Node;
import com.telepathylabs.codechallenge2.exception.InvalidExpression;

public interface OperationsExecutor {

    Integer evaluateInfixExpression(String input) throws Exception;

    Node buildBinaryTreeNodesFromInfix(String input) throws InvalidExpression;
}
