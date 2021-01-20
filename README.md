# MySQL

## How to get into your database in docker

```
$ create table people_info ( id int auto_increment not null primary key, name varchar(30) not null, secondname varchar(30) not null, age int not null, state varchar(30) not null);
$ docker exec -it MySQL mysql -uroot -p # password: 123, MySQL is our container name
$ docker run --name=MySQL -e MYSQL_ROOT_PASSWORD=123 -d mysql/mysql-server:latest
$ docker run -e MYSQL_ROOT_PASSWORD=password -d -p 3308:3306 mysql
```

# Postgres

## How to get into your database in docker

If you don’t specify the PGUSER environment variable, then psql will assume you want to use the current OS user as your database user name. In this case, you are using root as your OS user, and you will attempt to log in as root, but that user doesn’t exist in the database.

You’ll need to either call psql with the `-U Postgres` flag, or `su - Postgres` first
```
$ docker run --name postgres -p 5432:5432 -e POSTGRES_PASSWORD=123 -d postgres
$ docker start --name dazzling_goodall #dazzling_goodall is your container name
$ docker exec -it postgres bash --open bash in your container 
$ psql -U Postgres #-U = User
$ psql -h localhost -p 52 -U postgres -W
//or
$ psql -d test -U postgres #better use this # test is our database name

psql# \c databasename -- connect to database
people=#            
    create table people_info(
    id serial primary key,
    name varchar(30),
    secondname varchar(30),
    age int,
    state varchar(30));
```
In Postgres you are connecting to your Database immediately

# Mongo

## How to get into your database in docker

```
$ docker run -d -p 27017-27019:27017-27019 --name mongodb mongo
$ docker exec -it mongodb bash # Mongo is our container name
$ mongo
> use people; # We are into our database named db now.
> 
```


# Couch DB

## How to get into your database in docker

```
$ docker run -p 5984:5984 -e COUCHDB_USER=admin -e COUCHDB_PASSWORD=123 -d --name couchdb couchdb
```
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
- [ ] Dorobić reszte 