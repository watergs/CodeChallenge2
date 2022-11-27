package com.telepathylabs.codechallenge2.common.model;

import lombok.Data;

@Data
public class Node {

    public Node(String data) {
        this.data = data;
    }
    private String data;
    private Node leftNode;
    private Node rightNode;
}
