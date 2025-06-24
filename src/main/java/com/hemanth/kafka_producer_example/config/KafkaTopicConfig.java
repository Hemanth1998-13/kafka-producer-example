package com.hemanth.kafka_producer_example.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic createNewTopic(){
        return new NewTopic("topic-by-spring",3,(short) 1);
    }
}
