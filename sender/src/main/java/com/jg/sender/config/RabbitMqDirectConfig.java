package com.jg.sender.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Based on the routing key a message is sent to the queue having the same routing key specified in the binding rule.
 * The routing key of exchange and the binding queue have to be an exact match. A message is sent to exactly one queue.
 */
@Configuration
public class RabbitMqDirectConfig {

    public static final String EXCHANGE_NAME = "direct-exchange";

    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange(EXCHANGE_NAME);
    }

    @Bean
    public Binding marketingBindingForDirect(Queue marketingQueue, DirectExchange exchange) {
        return BindingBuilder.bind(marketingQueue).to(exchange).with("marketing");
    }

    @Bean
    public Binding financeBindingForDirect(Queue financeQueue, DirectExchange exchange) {
        return BindingBuilder.bind(financeQueue).to(exchange).with("finance");
    }

    @Bean
    public Binding adminBindingForDirect(Queue adminQueue, DirectExchange exchange) {
        return BindingBuilder.bind(adminQueue).to(exchange).with("admin");
    }

}
