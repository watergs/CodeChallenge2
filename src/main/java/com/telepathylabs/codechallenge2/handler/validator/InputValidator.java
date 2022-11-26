package com.telepathylabs.codechallenge2.handler.validator;

public interface InputValidator<Output, Input> {

    Output validate(Input input);

    Output validate();
}
