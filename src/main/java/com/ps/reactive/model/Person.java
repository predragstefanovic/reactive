package com.ps.reactive.model;

import lombok.Data;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Data
@Table(value = "people")
public class Person {

    @PrimaryKey
    private PersonKey key;

    @Column(value = "employment")
    private String employment;
}
