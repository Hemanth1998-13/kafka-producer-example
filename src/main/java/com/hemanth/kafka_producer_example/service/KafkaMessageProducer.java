package com.hemanth.kafka_producer_example.service;

import com.hemanth.kafka_producer_example.dto.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class KafkaMessageProducer {

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    public void sendMessageToKafka(Customer customer){

        CompletableFuture<SendResult<String, Object>> quickstart = kafkaTemplate.send("new-topic", customer);
        quickstart.whenComplete((result,ex) ->
        {
            if(ex == null)
                System.out.println("Message Sent offset is: "+result.getRecordMetadata().offset());
            else
                System.out.println("Unable to send the message to kafka cluster");
        });
    }
}
