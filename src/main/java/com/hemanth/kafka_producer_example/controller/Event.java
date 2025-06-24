package com.hemanth.kafka_producer_example.controller;

import com.hemanth.kafka_producer_example.service.KafkaMessageProducer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/producer")
public class Event {

    @Autowired
    private KafkaMessageProducer kafkaMessageProducer;

    @GetMapping("/publish/{message}")
    public ResponseEntity<?> sendMessageToKafkaServer(@PathVariable String message){
        try {
            kafkaMessageProducer.sendMessageToKafka(message);
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return  new ResponseEntity<>(HttpStatus.OK);

    }
}
