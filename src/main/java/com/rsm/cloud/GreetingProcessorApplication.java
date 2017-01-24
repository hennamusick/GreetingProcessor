package com.rsm.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.messaging.handler.annotation.SendTo;

@SpringBootApplication
@EnableBinding(Processor.class)
public class GreetingProcessorApplication {

	public static void main(String[] args) {
		SpringApplication.run(GreetingProcessorApplication.class, args);
	}
	
	@StreamListener(Processor.INPUT) @SendTo(Processor.OUTPUT)
	public String handle(ReceivedGreeting receivedGreeting) {
		return receivedGreeting.getGreeting().toUpperCase();
	}
}
