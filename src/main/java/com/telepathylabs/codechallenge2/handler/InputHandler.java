package com.telepathylabs.codechallenge2.handler;

public interface InputHandler<Output, Input> {

    Output handle(Input input);
}
