
# Demo on Spring reactive

## Dependencies

### PostgreSql - https://hub.docker.com/_/postgres

```
$ docker run --name postgres -p 5432:5432 -e POSTGRES_PASSWORD=postgres -d postgres
```

Recommended client: pgcli - https://pypi.org/project/pgcli/:

```
pgcli -h localhost -p 5432 postgres -U postgres
```

### Cassandra - https://hub.docker.com/_/cassandra

```
$ docker run --name cassandra -p 127.0.0.1:9042:9042 -p 127.0.0.1:9160:9160 -p 127.0.0.1:7000:7000 -p127.0.0.1:7001:7001  -d cassandra
```
 
Install cqlsh: https://docs.datastax.com/en/install/6.8/install/installCqlsh.html
