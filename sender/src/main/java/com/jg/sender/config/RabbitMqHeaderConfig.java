package com.jg.sender.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.HeadersExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * In this type of exchange the routing queue is selected based on the criteria specified in the headers instead of the routing key.
 * This is similar to topic exchange type, but here we can specify complex criteria for selecting routing queues.
 */
@Configuration
public class RabbitMqHeaderConfig {

    public static final String EXCHANGE_NAME = "header-exchange";

    @Bean
    public HeadersExchange headerExchange() {
        return new HeadersExchange(EXCHANGE_NAME);
    }

    @Bean
    public Binding marketingBindingForHeader(Queue marketingQueue, HeadersExchange headerExchange) {
        return BindingBuilder.bind(marketingQueue).to(headerExchange).where("department").matches("marketing");
    }

    @Bean
    public Binding financeBindingForHeader(Queue financeQueue, HeadersExchange headerExchange) {
        return BindingBuilder.bind(financeQueue).to(headerExchange).where("department").matches("finance");
    }

    @Bean
    public Binding adminBindingForHeader(Queue adminQueue, HeadersExchange headerExchange) {
        return BindingBuilder.bind(adminQueue).to(headerExchange).where("department").matches("admin");
    }

}
