package com.ps.reactive.db.cassandra;

import org.springframework.data.repository.reactive.ReactiveSortingRepository;

public interface CassandraReactiveRepository extends ReactiveSortingRepository<Person, PersonKey> {
}