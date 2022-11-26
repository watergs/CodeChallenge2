package com.telepathylabs.codechallenge2.handler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class AbstractInputHandler<Output, Input> implements InputHandler<Output, Input> {

    public Output handle(Input input) {
        logInput(input);
        Output validationError = validateInput(input);
        if(validationError != null) {
            return validationError;
        }
        return doHandle(input);
    }
    protected abstract Output validateInput(Input input);

    protected void logInput(Input input){
        log.debug("Input: ", input);
    }

    protected abstract Output doHandle(Input input);
}
