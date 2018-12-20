package com.malloc.springbootmicroservice.alexa;

import org.springframework.stereotype.Component;

import com.amazon.speech.json.SpeechletRequestEnvelope;
import com.amazon.speech.speechlet.IntentRequest;
import com.amazon.speech.speechlet.LaunchRequest;
import com.amazon.speech.speechlet.SessionEndedRequest;
import com.amazon.speech.speechlet.SessionStartedRequest;
import com.amazon.speech.speechlet.SpeechletResponse;
import com.amazon.speech.speechlet.SpeechletV2;

@Component
public class HandlerSpeechlet implements SpeechletV2 {

	public void onSessionStarted(SpeechletRequestEnvelope<SessionStartedRequest> requestEnvelope) {
		// This is invoked when a new Alexa session is started.  Any initialization logic would go here. 
		// You can store stuff in the Alexa session, for example, by calling:
		// 		Session session = requestEnvelope.getSession();
	}
	
	public SpeechletResponse onLaunch(SpeechletRequestEnvelope<LaunchRequest> requestEnvelope) {
		return null;
		// This is called when the skill is started with no specific intent.  
		// Such as "Alexa, ask MyDemoApp."
		// When this happens, we should provide a welcome message and prompt 
		// the user to ask a question.
	}

	public SpeechletResponse onIntent(SpeechletRequestEnvelope<IntentRequest> requestEnvelope) {
		return null;
		// This is invoked whenever an intent is invoked for our application.  We need
		// to figure out which intent it is, then respond.
	}

	public void onSessionEnded(SpeechletRequestEnvelope<SessionEndedRequest> requestEnvelope) {
		// This is invoked whenever session ends.  We can use this to clean up if needed.
	}
}
