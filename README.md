# dynatrace-dubbo-demo
the project is to provider a demo project for distributed tracing provided by dynatrace appmon for dubbo application.

## build
under fold "dynatrace-dubbo-demo", execute build command.
```sh
mvn clean install
```

## run
1. start Apache Zookeeper.
2. under fold "dynatrace-dubbo-demo\dubbo-demo-consumer\target", start dubbo-demo-consumer.
```java
java -jar dubbo-demo-consumer-1.4.5.RELEASE.jar
```
3. under fold "dynatrace-dubbo-demo\dubbo-demo-provider\target", start dubbo-demo-provider.
```java
java -jar dubbo-demo-provider-1.4.5.RELEASE.jar
```

## test
to test the result: http://localhost:8080/dubbo/home

## monitor (optional)
to mintor the application with dynatrace appmon. 
add jvm argument to dubbo consumer.
```sh
-agentpath:"C:\Program Files\dynaTrace\dynaTrace 6.5\agent\lib64\dtagent.dll"=name=dubbo-consumer,server=localhost
```
add jvm argument to dubbo provider.
```sh
-agentpath:"C:\Program Files\dynaTrace\dynaTrace 6.5\agent\lib64\dtagent.dll"=name=dubbo-provider,server=localhost
```

## topology
automatically disovered topology by dynatrace appmon
![TransactionFlow](https://github.com/DeanWade/deanwade.github.io/blob/master/image/dynatrace/dubbo/TransactionFlow.png)

## method level tracing
![TransactionFlow](https://github.com/DeanWade/deanwade.github.io/blob/master/image/dynatrace/dubbo/PurePath.png)

