package com.jg.sender.controller;

import com.jg.sender.config.RabbitMqDirectConfig;
import com.jg.sender.config.RabbitMqFanoutConfig;
import com.jg.sender.config.RabbitMqHeaderConfig;
import com.jg.sender.config.RabbitMqTopicConfig;
import com.jg.sender.producer.RabbitMqProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RabbitMqWebController {

    @Autowired
    private RabbitMqProducer rabbitMQSender;

    @GetMapping(value = "/default")
    public String defaultExchange(@RequestParam("message") String message) {
        rabbitMQSender.send(message);
        return "Message sent to the RabbitMQ Successfully";
    }

    @GetMapping(value = "/direct")
    public String directExchange(@RequestParam("routingKey") String routingKey,
                           @RequestParam("message") String message) {
        rabbitMQSender.send(RabbitMqDirectConfig.EXCHANGE_NAME, routingKey, message);
        return "Message sent to the RabbitMQ Successfully";
    }

    @GetMapping(value = "/fanout")
    public String fanoutExchange(@RequestParam("routingKey") String routingKey,
                                 @RequestParam("message") String message) {
        rabbitMQSender.send(RabbitMqFanoutConfig.EXCHANGE_NAME, routingKey, message);
        return "Message sent to the RabbitMQ Successfully";
    }

    @GetMapping(value = "/topic")
    public String topicExchange(@RequestParam("routingKey") String routingKey,
                                @RequestParam("message") String message) {
        rabbitMQSender.send(RabbitMqTopicConfig.EXCHANGE_NAME, routingKey, message);
        return "Message sent to the RabbitMQ Successfully";
    }

    @GetMapping(value = "/header")
    public String headerExchange(@RequestHeader("department") String department, @RequestParam("message") String message) {
        rabbitMQSender.send(department, message);
        return "Message sent to the RabbitMQ Successfully";
    }

}
