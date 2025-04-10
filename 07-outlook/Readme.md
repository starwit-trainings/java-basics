# Outlook

## HTTP and network
* About TCP/IP & why it is everywhere
* HTTP introduction
* HTTP Requests & response codes 
  * https://en.wikipedia.org/wiki/HTTP#HTTP/1.1_request_messages
  * https://http.cat/ :D
* useful tools
  * telnet/ping
  * traceroute / route
  * cURL

## REST services as a general technology
* REST pattern as an interface technology
* Payloads: JSON
* Why it fits so well to stuff in a database
* Web APIs

## Authentication

### Accessing APIs with Tokens - plain Java
APIs should never be accessed without authentication. In this example we want access an API for which access token are necessary.

```bash
    cd auth-token
    mvn clean package
    java -jar target/auth-token.jar
```

#### Concepts
* [openID](https://en.wikipedia.org/wiki/OpenID#OpenID_Connect_(OIDC))
* [JSON Web Token](https://en.wikipedia.org/wiki/JSON_Web_Token)

#### Tasks
* run app


### Accessing APIs with Tokens - Spring Boot
APIs should never be accessed without authentication. In this example we want access an API for which access token are necessary.

```bash
    cd auth-token-spring
    mvn clean package
    java -jar target/auth-token-spring.jar
```

#### Concepts
* [openID](https://en.wikipedia.org/wiki/OpenID#OpenID_Connect_(OIDC))
* [JSON Web Token](https://en.wikipedia.org/wiki/JSON_Web_Token)

#### Tasks
* run app
* Build function, that calls API every 5 seconds
* Enhance function, that checks if token is still valid and if not, request a new one.

## Defining APIs with openAPI
* Design by contract
* Generating code
* Some examples

## On Spring Boot
* About business logic
* Software architecture & streamlining development
* Many features yet still fast
* Frontends...