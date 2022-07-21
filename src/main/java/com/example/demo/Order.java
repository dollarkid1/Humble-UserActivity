package com.example.demo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;

@NoArgsConstructor
@Data
@Document
@Table(name = "CUSTOMER_ORDER")
public class Order {
    @Id @GeneratedValue
    private Long id;

    private String description;

    private Status status;


    public Order(String description, Status status) {
        this.description = description;
        this.status = status;
    }
}
