package com.ps.reactive.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractReactiveCassandraConfiguration;

@Configuration
public class CassandraConfig extends AbstractReactiveCassandraConfiguration {

    public String getKeyspaceName() {
        return "demo";
    }

    public String[] getEntityBasePackages() {
        return new String[]{"com.ps.db.cassandra"};
    }

    public String getContactPoints() {
        return "localhost";
    }
}

