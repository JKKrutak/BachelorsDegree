# MySQL

## How to get into your database in docker

```
$ docker exec -it MySQL mysql -uroot -p # password: 123, MySQL is our container name
```

# Postgres

## How to get into your database in docker

If you don’t specify the PGUSER environment variable, then psql will assume you want to use the current OS user as your database user name. In this case, you are using root as your OS user, and you will attempt to log in as root, but that user doesn’t exist in the database.

You’ll need to either call psql with the `-U Postgres` flag, or `su - Postgres` first
```
$ psql -U Postgres #-U = User
$ psql -h localhost -p 52 -U postgres -W
//or
$ psql -d test -U postgres #better use this # test is our database name
```
In Postgres you are connecting to your Database immediately

# Mongo

## How to get into your database in docker

```
$ docker exec -it Mongo bash # Mongo is our container name
$ mongo
> use db; # We are into our database named db now.
```


# Couch DB

## How to get into your database in docker

Just type http://127.0.0.1:5984/_utils/#login - localhost- in your web browser, and login.
 
# Cassandra:

## How to get into your database in docker

Default password is "cassandra"

Start by creating network:

`$ docker network create some-network`
then:

```
$ docker run --name x --network some-network -d cassandra:latest #x is your container name
```
Create another container dedicated for executing Cassandra Query Language Shell 

```
$ dock r run --name my-cassandra-1 --network some-network -d -e CASSANDRA_SEEDS=cassandra cassandra:latest
$ docker run -it --rm --network some-network cassandra:latest cqlsh x #x is your container name
```

# TODO:


- [ ] Add performance measurement for other queries (Update, Delete all)
- [ ] Try to add some new database 