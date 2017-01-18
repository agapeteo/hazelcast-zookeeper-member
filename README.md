# hazelcast-zookeeper-member
Hazelcast instance automatically joins cluster with Zookeeper discovery. Created mostly for Docker, but can run outside Docker

**build docker image example**<br>
`mvn clean package docker:build`

**run with docker-compose example**<br>
`docker-compose up -d`

it will also run web ui for Zookeeper on port 9090


**scale with docker-compose example**<br>
`docker-compose scale hazelcast=2`
<br>

**useful Zookeeper commands**<br>
`echo ruok | nc localhost 2181`<br>
`echo conf | nc localhost 2181`<br>
`echo cons | nc localhost 2181`<br>
`echo stat | nc localhost 2181`<br>

`echo dump | nc localhost 2181` <br>will display hazelcast members
<br>


**Docker start container**<br>
`docker run -p 5701:5701 -e ZOOKEEPER_URL=${ZOOKEEPER_SERVER}:2181 -d agapeteo/hazelcast-zookeeper-member`
<br>
all optional environment variables:
- *ZOOKEEPER_URL* - Zookeeper URL (default: localhost)
- *ZOOKEEPER_PATH* - Zookeeper config path (default: /discovery/hazelcast) 
- *ZOOKEEPER_GROUP* - Zookeeper config group (default: defaultHazelcastGroup) 

<br>
**TODO:**
- remote shell
- even more flexible configuration
