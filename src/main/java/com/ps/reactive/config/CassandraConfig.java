package com.ps.reactive.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.repository.config.EnableReactiveCassandraRepositories;

@Configuration
@EnableReactiveCassandraRepositories(
        basePackages = {
                "com.ps.db.cassandra"
        })
public class CassandraConfig extends AbstractCassandraConfiguration {

    protected String getKeyspaceName() {
        return "keyspace";
    }

    public String[] getEntityBasePackages() {
        return new String[]{"com.ps.db.cassandra"};
    }
}

