	package com.springone.asyncapi.datacollector;

import java.math.BigDecimal;
import java.util.function.Supplier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.binder.BinderHeaders;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;

import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.hardware.Sensors;

@SpringBootApplication
public class Application {
	// The @Value annotation exposes access to application properties
    @Value("${application.latitude}")
    public BigDecimal latitude;
    @Value("${application.longitude}")
    public BigDecimal longitude;
    @Value("${application.city}")
    public String city;

	private static final Logger logger = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	Supplier<Message<TemperatureReading>> publishTemperatureData()  {
		return () -> {
			// Collect CPU metrics 
	        SystemInfo si = new SystemInfo();
	        HardwareAbstractionLayer hal = si.getHardware();
		    Sensors sensors = hal.getSensors();
		    CentralProcessor processor = hal.getProcessor();
	        double[] loadAverage = processor.getSystemLoadAverage(1);
			BigDecimal cpuLoad = new BigDecimal((loadAverage[0] < 0 ? 0 : loadAverage[0]));
			BigDecimal cpuTemp = new BigDecimal(50.0 + cpuLoad.doubleValue() * 8.0);
		    
			// TODO: Construct the topic name with alert type and priority as per the Topic hierarchy design
            // 		SmartTown/Operations/temperatureReading/created/v1/{city}/{latitude}/{longitude}
	        String topic = "";	        			
			TemperatureReading data = new TemperatureReading(cpuLoad, city, latitude, longitude, cpuTemp);
			
			logger.info(data.toString());	

			// Set the target destination as the constructed topic name
	        return MessageBuilder.withPayload(data)
	        			.setHeader(BinderHeaders.TARGET_DESTINATION, topic)
	        			.build();		
		};
	}	

}
