package com.ps.reactive.order;


import com.ps.reactive.model.Order;
import com.ps.reactive.model.db.postgres.OrderRepository;
import org.reactivestreams.Publisher;
import org.springframework.data.cassandra.core.ReactiveCassandraOperations;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.net.URI;

@Component
public class OrderHandler {

    final OrderRepository orderRepository;
    final ReactiveCassandraOperations peopleDb;

    public OrderHandler(ReactiveCassandraOperations peopleDb, OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
        this.peopleDb = peopleDb;
    }

    public Mono<ServerResponse> create(ServerRequest request) {
        Flux<Order> flux = request
                .bodyToFlux(Order.class)
                .flatMap(this.orderRepository::save);
        return defaultWriteResponse(flux);
    }

    public Mono<ServerResponse> all(ServerRequest r) {
        return defaultReadResponse(this.orderRepository.findAll());
    }

    public Mono<ServerResponse> deleteById(ServerRequest r) {
        return defaultReadResponse(this.orderRepository
                .findById(id(r))
                .flatMap(o ->
                        this.orderRepository.deleteById(o.getId())
                                .thenReturn(o)
                )
        );
    }

    public Mono<ServerResponse> getById(ServerRequest r) {
        return defaultReadResponse(this.orderRepository.findById(id(r)));
    }

    private static Mono<ServerResponse> defaultReadResponse(Publisher<Order> orders) {
        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(orders, Order.class);
    }

    private static Mono<ServerResponse> defaultWriteResponse(Publisher<Order> order) {
        return Mono
                .from(order)
                .flatMap(p -> ServerResponse
                        .created(URI.create("/order"))
                        .contentType(MediaType.APPLICATION_JSON)
                        .build()
                );
    }

    private static int id(ServerRequest r) {
        return Integer.parseInt(r.pathVariable("id"));
    }

}
