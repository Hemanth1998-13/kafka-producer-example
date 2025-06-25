package com.hemanth.kafka_producer_example.controller;

import com.hemanth.kafka_producer_example.dto.Customer;
import com.hemanth.kafka_producer_example.service.KafkaMessageProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/producer")
public class Event {

    private static final Logger log = LoggerFactory.getLogger(Event.class);
    @Autowired
    private KafkaMessageProducer kafkaMessageProducer;

    @PostMapping
    public ResponseEntity<?> sendMessageToKafkaServer(@RequestBody Customer customer){
        try {
                kafkaMessageProducer.sendMessageToKafka(customer);
                log.info("Message published: "+customer.toString());
        }catch (Exception e) {
                e.printStackTrace();
        }
        return  new ResponseEntity<>(HttpStatus.OK);

    }
}
