
# Demo on Spring reactive

## Dependencies

### PostgreSql - https://hub.docker.com/_/postgres

```
$ docker run --name some-postgres -e POSTGRES_PASSWORD=mysecretpassword -d postgres:tag
```

(recommended client: pgcli - https://pypi.org/project/pgcli/)

### Cassandra - https://hub.docker.com/_/cassandra

```
$ docker run --name some-cassandra --network some-network -d cassandra:tag
```
