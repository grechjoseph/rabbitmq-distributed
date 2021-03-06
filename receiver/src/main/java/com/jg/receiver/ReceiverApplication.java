package com.jg.receiver;

import com.jg.receiver.config.RabbitConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

@SpringBootApplication
@EnableBinding(RabbitConfig.class)
public class ReceiverApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReceiverApplication.class, args);
	}

}
