package com.jg.senderproperties.config;


import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface RabbitConfig {

    String EXCHANGE_NAME = "properties-exchange";

    @Output(RabbitConfig.EXCHANGE_NAME)
    MessageChannel propertiesExchange();

}
