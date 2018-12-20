package com.malloc.springbootmicroservice.alexa;

import org.springframework.stereotype.Component;

import com.amazon.speech.json.SpeechletRequestEnvelope;
import com.amazon.speech.slu.Intent;
import com.amazon.speech.speechlet.IntentRequest;
import com.amazon.speech.speechlet.LaunchRequest;
import com.amazon.speech.speechlet.Session;
import com.amazon.speech.speechlet.SessionEndedRequest;
import com.amazon.speech.speechlet.SessionStartedRequest;
import com.amazon.speech.speechlet.SpeechletException;
import com.amazon.speech.speechlet.SpeechletResponse;
import com.amazon.speech.speechlet.SpeechletV2;
import com.amazon.speech.ui.Card;
import com.amazon.speech.ui.PlainTextOutputSpeech;

@Component
public class HandlerSpeechlet implements SpeechletV2 {

    @Override
    public void onSessionStarted(SpeechletRequestEnvelope<SessionStartedRequest> requestEnvelope) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public SpeechletResponse onLaunch(SpeechletRequestEnvelope<LaunchRequest> requestEnvelope) {
        Session session = requestEnvelope.getSession();
        AlexaUtils.setConversationMode(session, true);

        // Create the initial greeting speech.
        String speechText = "Hello. " + AlexaUtils.SamplesHelpText;
        
        Card card = AlexaUtils.newCard("Welcome!", speechText);
        PlainTextOutputSpeech speech = AlexaUtils.newSpeech(speechText, false);
        
        return AlexaUtils.newSpeechletResponse(card, speech, session, false);

    }

    @Override
    public SpeechletResponse onIntent(SpeechletRequestEnvelope<IntentRequest> requestEnvelope) 
    {
        System.out.println(requestEnvelope.getRequest().getRequestId() + " : " + requestEnvelope.getSession().getSessionId());

        Intent intent = requestEnvelope.getRequest().getIntent();
        String intentName = intent.getName();

        if ("HelloWorldIntent".equals(intentName)) {
            System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaa");
        }
        return null; 
    }

    @Override
    public void onSessionEnded(SpeechletRequestEnvelope<SessionEndedRequest> requestEnvelope) {
        // TODO Auto-generated method stub
        
    }

	
}
