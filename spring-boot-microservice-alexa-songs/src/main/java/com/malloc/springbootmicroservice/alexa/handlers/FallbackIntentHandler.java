package com.malloc.springbootmicroservice.alexa.handlers;

import java.util.Optional;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;

public class FallbackIntentHandler implements RequestHandler {

    @Override
    public boolean canHandle(HandlerInput input) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Optional<Response> handle(HandlerInput input) {
        // TODO Auto-generated method stub
        return null;
    }

}
