package com.hemanth.kafka_producer_example.dto;

import lombok.Data;

@Data
public class Customer {
    private int id;
    private String Name;
    private String email;
}
