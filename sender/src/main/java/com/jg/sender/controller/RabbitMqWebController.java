package com.jg.sender.controller;

import com.jg.sender.producer.RabbitMqProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RabbitMqWebController {

    @Autowired
    private RabbitMqProducer rabbitMQSender;

    @GetMapping(value = "/producer")
    public String producer(@RequestParam("message") String message) {
        rabbitMQSender.send(message);
        return "Message sent to the RabbitMQ Successfully";
    }

}
