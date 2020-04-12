package com.jg.senderproperties.controller;

import com.jg.senderproperties.config.RabbitConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RabbitMqWebController {

    @Autowired
    private RabbitConfig rabbitConfig;

    @GetMapping(value = "/events")
    public String fanoutExchange(@RequestParam("routingKey") String routingKey,
                                 @RequestParam("message") String message) {
        Message msg = MessageBuilder.withPayload(message).build();
        rabbitConfig.propertiesExchange().send(msg);
        return "Message sent to the RabbitMQ Successfully";
    }

}
