package com.telepathylabs.codechallenge2.handler.validator;

public abstract class AbstractRequestValidator {

    protected final String buildErrorMessage(String cause) {
        return cause;
    }
}
