package com.telepathylabs.codechallenge2.executor.impl;

import com.telepathylabs.codechallenge2.common.model.Node;
import com.telepathylabs.codechallenge2.common.utils.ExpressionSolverUtils;
import com.telepathylabs.codechallenge2.executor.OperationsExecutor;
import org.springframework.stereotype.Component;

import java.util.Stack;

@Component
public class OperationsExecutorImpl implements OperationsExecutor {

    private static char CHAR_ZERO = '0';
    private static char OPENING_ROUND_BRACES = '(';
    private static char CLOSING_ROUND_BRACES = ')';
    private static String SPACE = " ";
    private static char MINUS_OPERATION = '-';

    @Override
    public Integer evaluateInfixExpression(String infixExpression) throws RuntimeException{

        Stack<Integer> operands = new Stack<>();
        Stack<Character> operations = new Stack<>();

        int indexOfLastOperation = -1;
        boolean isNegativeNumber = false;

        for (int charIndex = 0; charIndex < infixExpression.length(); charIndex++) {
            char currentChar = infixExpression.charAt(charIndex);

            if (Character.isDigit(currentChar)) {
                int currentNumber = 0;

                while (Character.isDigit(currentChar)) {
                    int currentDigit = currentChar - CHAR_ZERO;
                    currentNumber = currentNumber * 10 + currentDigit;
                    charIndex++;

                    if (charIndex < infixExpression.length()) {
                        currentChar = infixExpression.charAt(charIndex);
                    } else {
                        break;
                    }
                }
                charIndex--;
                if (isNegativeNumber) {
                    currentNumber *= -1;
                    isNegativeNumber = false;
                }
                operands.push(currentNumber);
            } else if (currentChar == OPENING_ROUND_BRACES) {
                operations.push(currentChar);
            } else if (currentChar == CLOSING_ROUND_BRACES) {
                while (operations.peek() != OPENING_ROUND_BRACES) {
                    solveCurrentOperationAndPush(operands, operations);
                }
                operations.pop();
            } else if (ExpressionSolverUtils.isOperator(currentChar)) {
                if (indexOfLastOperation == charIndex - 1 && currentChar == MINUS_OPERATION) {
                    isNegativeNumber = true;
                } else {
                    indexOfLastOperation = charIndex;
                    while (!operations.isEmpty() && ExpressionSolverUtils.operatorPrecedence(currentChar)
                            <= ExpressionSolverUtils.operatorPrecedence(operations.peek())) {
                        solveCurrentOperationAndPush(operands, operations);
                    }
                    operations.push(currentChar);
                }
            }
        }
        while (!operations.isEmpty()) {
            solveCurrentOperationAndPush(operands, operations);
        }
        return operands.size() != 0 ? operands.pop() : null;
    }

    @Override
    public Node buildBinaryTreeNodesFromInfix(String input) {

        Stack<Node> nodeStack = new Stack<>();
        Stack<Character> characterStack = new Stack<>();

        input = OPENING_ROUND_BRACES + input + CLOSING_ROUND_BRACES;

        int indexOfLastOperation = -1;
        boolean isNegativeNumber = false;

        Node mainNode;
        for(int charIndex = 0; charIndex < input.length(); charIndex++) {
            char currentChar = input.charAt(charIndex);

            if (Character.isDigit(currentChar)) {
                int currentNumber = 0;

                while (Character.isDigit(currentChar)) {
                    int currentDigit = currentChar - CHAR_ZERO;
                    currentNumber = currentNumber * 10 + currentDigit;
                    charIndex++;

                    if (charIndex < input.length()) {
                        currentChar = input.charAt(charIndex);
                    } else {
                        break;
                    }
                }
                charIndex--;
                if (isNegativeNumber) {
                    currentNumber *= -1;
                    isNegativeNumber = false;
                }

                nodeStack.add(new Node(String.valueOf(currentNumber)));
            } else if(currentChar == OPENING_ROUND_BRACES) {
                characterStack.add(currentChar);
            } else if (currentChar == CLOSING_ROUND_BRACES) {
                while (!characterStack.isEmpty() && characterStack.peek() != OPENING_ROUND_BRACES) {
                    mainNode = new Node(String.valueOf(characterStack.pop()));
                    Node leftNode = nodeStack.pop();
                    Node rightNode = nodeStack.pop();
                    mainNode.setLeftNode(leftNode);
                    mainNode.setRightNode(rightNode);
                    nodeStack.add(mainNode);
                }
                characterStack.pop();
            } else if (ExpressionSolverUtils.isOperator(currentChar)) {
                if (indexOfLastOperation == charIndex - 1 && currentChar == MINUS_OPERATION) {
                    isNegativeNumber = true;
                } else {
                    indexOfLastOperation = charIndex;
                    while (!characterStack.isEmpty() && ExpressionSolverUtils.operatorPrecedence(currentChar)
                            <= ExpressionSolverUtils.operatorPrecedence(characterStack.peek())) {
                        mainNode = new Node(String.valueOf(characterStack.pop()));
                        Node leftNode = nodeStack.pop();
                        Node rightNode = nodeStack.pop();
                        mainNode.setLeftNode(leftNode);
                        mainNode.setRightNode(rightNode);
                        nodeStack.add(mainNode);
                    }
                    characterStack.push(currentChar);
                }
            }
        }
        return nodeStack.peek();
    }

    private void solveCurrentOperationAndPush(Stack<Integer> operands, Stack<Character> operations) {
        int secondOperand = operands.pop(); // In a stack, the 2nd operand is pushed last, while 1st
        int firstOperand = operands.pop(); // operand is pushed first.

        char operation = operations.pop();
        int operationOutput = ExpressionSolverUtils.performOperations(secondOperand, firstOperand, operation);
        operands.push(operationOutput);
    }

}
