# rest-assured-reqres

A REST Assured framework that use the **Page Object Model** design pattern in an API context, that is each endpoint is a class.

It uses the **reqres** api: https://reqres.in/

To see it in action from the terminal run **mvn test**

There are a few basic assertions against each endpoint.

Each endpoint is also verified against:
* the reqres OpenAPI specification.
* the reqres JSON Schema for each endpoint's payload.