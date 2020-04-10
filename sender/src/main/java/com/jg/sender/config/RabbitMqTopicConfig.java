package com.jg.sender.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Here again the routing key is made use of. But unlike in direct exchange type, here the routing key of the exchange and
 * the bound queues should not necessarily be an exact match. Using regular expressions like wildcard we can send the exchange to multiple bound queues.
 */
@Configuration
public class RabbitMqTopicConfig {

    public static final String EXCHANGE_NAME = "topic-exchange";

    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange(EXCHANGE_NAME);
    }

    @Bean
    public Binding marketingBindingForTopic(Queue marketingQueue, TopicExchange topicExchange) {
        return BindingBuilder.bind(marketingQueue).to(topicExchange).with("queue.marketing");
    }

    @Bean
    public Binding financeBindingForTopic(Queue financeQueue, TopicExchange topicExchange) {
        return BindingBuilder.bind(financeQueue).to(topicExchange).with("queue.finance");
    }

    @Bean
    public Binding adminBindingForTopic(Queue adminQueue, TopicExchange topicExchange) {
        return BindingBuilder.bind(adminQueue).to(topicExchange).with("queue.admin");
    }

    @Bean
    public Binding allBindingForTopic(Queue allQueue, TopicExchange topicExchange) {
        return BindingBuilder.bind(allQueue).to(topicExchange).with("queue.*");
    }

}
