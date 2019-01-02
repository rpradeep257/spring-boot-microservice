package com.malloc.springbootmicroservice.alexa;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazon.ask.Skill;
import com.amazon.ask.Skills;
import com.amazon.ask.servlet.SkillServlet;
import com.malloc.springbootmicroservice.alexa.handlers.CancelandStopIntentHandler;
import com.malloc.springbootmicroservice.alexa.handlers.FallbackIntentHandler;
import com.malloc.springbootmicroservice.alexa.handlers.HelloWorldIntentHandler;
import com.malloc.springbootmicroservice.alexa.handlers.HelpIntentHandler;
import com.malloc.springbootmicroservice.alexa.handlers.LaunchRequestHandler;
import com.malloc.springbootmicroservice.alexa.handlers.SessionEndedRequestHandler;

import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;


@Configuration
public class HelloWorldConfig {
    
    int httpsPort = 443;
    int httpPort = 80;
    
    @Bean
    public ServletWebServerFactory servletContainer() {
        TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory() {
            @Override
            protected void postProcessContext(Context context) {
                SecurityConstraint securityConstraint = new SecurityConstraint();
                securityConstraint.setUserConstraint("CONFIDENTIAL");
                SecurityCollection collection = new SecurityCollection();
                collection.addPattern("/*");
                securityConstraint.addCollection(collection);
                context.addConstraint(securityConstraint);
            }
        };
        tomcat.addAdditionalTomcatConnectors(redirectConnector());
        return tomcat;
    }

    private Connector redirectConnector() {
        Connector connector = new Connector(TomcatServletWebServerFactory.DEFAULT_PROTOCOL);
        connector.setScheme("http");
        connector.setPort(httpPort);
        connector.setSecure(false);
        connector.setRedirectPort(httpsPort);
        return connector;
    }
    
    @Bean
    public ServletRegistrationBean<SkillServlet> registerServlet(Skill skillInstance) {
        SkillServlet skillServlet = new SkillServlet(skillInstance);
        return new ServletRegistrationBean<>(skillServlet, "/myskill1");
    }

    @Bean
    public Skill skillInstance() {
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
}

