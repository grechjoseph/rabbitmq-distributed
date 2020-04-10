package com.jg.sender.producer;

import com.jg.sender.config.RabbitMqHeaderConfig;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.amqp.support.converter.SimpleMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMqProducer {

    @Autowired
    private AmqpTemplate rabbitTmpl;

    @Value("${rabbitmq.exchange}")
    private String exchange;

    @Value("${rabbitmq.routingkey}")
    private String routingkey;

    public void send(String message) {
        rabbitTmpl.convertAndSend(exchange, routingkey, message);
        System.out.println("Send msg = " + message);
    }

    public void send(String header, String message) {
        MessageProperties messageProperties = new MessageProperties();
        messageProperties.setHeader("department", header);
        MessageConverter messageConverter = new SimpleMessageConverter();
        Message msg = messageConverter.toMessage(message, messageProperties);
        rabbitTmpl.send(RabbitMqHeaderConfig.EXCHANGE_NAME, "", msg);
    }

    public void send(String exchange, String routingkey, String message) {
        rabbitTmpl.convertAndSend(exchange, routingkey, message);
        System.out.println("Send msg = " + message);
    }
}
