package com.springone.asyncapi.alertgenerator;

import java.util.function.Function;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.binder.BinderHeaders;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

@SpringBootApplication
public class Application {

	private static final Logger logger = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class);
	}

	// Add @Bean annotation here (AsyncAPI codegen will fix this soon)
	@Bean
	public Function<TemperatureReading, Message<OperationalAlert>> processTemperatureReading() {
		return data -> {
			// Add business logic here.

			// NOTE: A return value of null indicates that no message will be published to the Broker 
			if (data.getMCpuTemp().doubleValue() <= 60)
				return null;
			
			// Since the goal is to generate temperature alerts, set the alertType to a 
			// default value of 'HighTemperature' 
			String alertType = "HighTemperature"; // HighCpuLoad
			
			// Based on the defined bounds for Low, Medium and High temperature,
			// check the incoming temperature reading and set the alert priority appropriately
			String alertPriority = "High";
			if (data.getMCpuTemp().doubleValue() > 60 && data.getMCpuTemp().doubleValue() <= 70)
				alertPriority = "Low";
			else if (data.getMCpuTemp().doubleValue() > 70 && data.getMCpuTemp().doubleValue() <= 80)
				alertPriority = "Medium";
			
			// Construct the topic name with alert type and priority as per the Topic hierarchy design
			//		SmartTown/Operations/OperationalAlert/created/v1/{AlertPriority}/{AlertType}
			String topic = String.format("SmartTown/Operations/OperationalAlert/created/v1/%s/%s",
				alertType, alertPriority);
			
			// Construct an OperatinalAlert object 
			OperationalAlert payload = new OperationalAlert(alertPriority, alertType, data.getMCity(), data.getMCpuTemp(), 
															data.getMLatitude(), data.getMLongitude());
			
		    logger.info("Operational Alert: \n" + payload.toString());

			// Add OperationalAlert as type parameter to Message declaration (AsyncAPI codegen will fix this soon)
			Message<OperationalAlert> message = MessageBuilder
				.withPayload(payload)
				.setHeader(BinderHeaders.TARGET_DESTINATION, topic)
				.build();

			return message;
		};
	}

}
