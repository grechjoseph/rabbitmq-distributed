package com.jg.senderproperties;

import com.jg.senderproperties.config.RabbitConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

@EnableBinding(RabbitConfig.class)
@SpringBootApplication
public class SenderPropertiesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SenderPropertiesApplication.class, args);
	}

}
