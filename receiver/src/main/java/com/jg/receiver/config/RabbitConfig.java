package com.jg.receiver.config;


import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface RabbitConfig {

    String EXCHANGE_NAME = "properties-exchange";

    @Input(RabbitConfig.EXCHANGE_NAME)
    SubscribableChannel propertiesExchange();

}
