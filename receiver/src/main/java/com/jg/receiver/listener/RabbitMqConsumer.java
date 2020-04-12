package com.jg.receiver.listener;

import com.jg.receiver.config.RabbitConfig;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
public class RabbitMqConsumer {

    /*
    @RabbitListener(queues = "${rabbitmq.queue}")
    public void receiveMessage(String message) {
        System.out.println("Received Message From RabbitMQ: " + message);
    }
     */

    @StreamListener(target = RabbitConfig.EXCHANGE_NAME)
    public void receiveMessage(Message<String> message) {
        System.out.println("Received Message from property configuration: " + message.getPayload());
    }
}
