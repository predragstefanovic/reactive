package com.ps.reactive.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table(value = "orders")
public class Order {

    @Id
    @Column(value = "o_id")
    private Integer id;

    @Column(value = "c_id")
    private String customerId;

    @Column(value = "total")
    private long totalInCents;
}
