package com.malloc.springbootmicroservice.alexa;


import com.amazon.ask.Skill;
import com.amazon.ask.SkillStreamHandler;
import com.amazon.ask.Skills;
import com.malloc.springbootmicroservice.alexa.handlers.CancelandStopIntentHandler;
import com.malloc.springbootmicroservice.alexa.handlers.FallbackIntentHandler;
import com.malloc.springbootmicroservice.alexa.handlers.HelloWorldIntentHandler;
import com.malloc.springbootmicroservice.alexa.handlers.HelpIntentHandler;
import com.malloc.springbootmicroservice.alexa.handlers.LaunchRequestHandler;
import com.malloc.springbootmicroservice.alexa.handlers.SessionEndedRequestHandler;


public class HelloWorldStreamHandler extends SkillStreamHandler {

    private static Skill getSkill() {
        return Skills.standard()
                .addRequestHandlers(
                        new CancelandStopIntentHandler(),
                        new HelloWorldIntentHandler(),
                        new HelpIntentHandler(),
                        new LaunchRequestHandler(),
                        new SessionEndedRequestHandler(),
                        new FallbackIntentHandler())
                // Add your skill id below
                .withSkillId("amzn1.ask.skill.904ec0de-d2c6-4713-91aa-c61c97f15699")
                .build();
    }

    public HelloWorldStreamHandler() {
        super(getSkill());
    }
}
