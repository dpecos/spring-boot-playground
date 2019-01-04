## Spring Modules

A complete list of all the `starter` modules can be found here: https://github.com/spring-projects/spring-boot/tree/master/spring-boot-project/spring-boot-starters

Reference docs: https://docs.spring.io/spring-boot/docs/current/reference/html/

## spring-boot-devtools

Links:
- https://docs.spring.io/spring-boot/docs/current/reference/html/using-boot-devtools.html

Features:
- Sets up some property defaults
- Automatic restart when files in classpath change
- Livereload
- Global settings using a file in user's $HOME
- Can be used with remote applications


## spring-boot-starter-web

https://www.baeldung.com/spring-boot-starters (Section 2)

Features:
- Adds support for HTTP / REST controllers


## spring-boot-actuator

Links:
- https://www.baeldung.com/spring-boot-actuators
- https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#production-ready-endpoints
- https://docs.spring.io/spring-boot/docs/current/reference/html/boot-features-security.html#boot-features-security-actuator

Features:
- Actuator endpoints have to be enabled and exposed to be able to interact with them.
- Shutdown endpoint has to be explicitly enabled: `management.endpoint.shutdown.enabled=true`

These endpoints can be secured with `spring-boot-starter-security`.

`http :8080/actuator/health --auth user:password`

Note: these credentials are setup by `spring-boot-starter-security`

### git details

`info` actuator's endpoint will expose information about git repository if a `git.properties` file is found in the root 
of the classpath. That file can be generated with the `git-commit-id-plugin` plugin:

`http :8080/actuator/info --auth user:password` 

In order to show full git details, the following property must be set:

`management.info.git.mode=full`


## spring-boot-starter-security

Links:
- https://docs.spring.io/spring-boot/docs/current/reference/html/boot-features-security.html
- https://docs.spring.io/spring-security/site/docs/5.1.2.RELEASE/reference/html/

Features:
- Adds security defaults for a web application
- Supports MVC & WebFlux modules
- Oauth2
- Adds actuator security

## spring-boot-starter-test

Links: 
- https://docs.spring.io/spring-boot/docs/current/reference/html/boot-features-testing.html
- https://www.baeldung.com/rest-assured-tutorial

Features:
- `spring-boot-starter-test` provides `@SpringBootTest` to setup web tests
- RestAssured is the library chosen to express web tests (it's important to setup the port the application has picked up)