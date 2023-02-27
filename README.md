# rest-assured-http-client

A REST Assured framework that use the **Page Object Model** design pattern in an API context, that is each endpoint is a class.

It can be used as an HTTP Client (like Postman):
* Responses can be saved to a file.
* Can chain endpoints together by adding calling another endpoint via its methods.
*  Headers can be altered for negative testing.

It uses the **reqres** api: https://reqres.in/

There are a few basic assertions against each endpoint.

All JSON used within an HTTP request (POST bodies, Response payloads) is modelled as a POJO.

Each endpoint's response is also verified against:
* the reqres OpenAPI specification.
* the reqres JSON Schema for each endpoint's payload.

You will need to change one configuration.properties
**write_payload_location** to point to the file you want the responses saved to.

To see it in action from the terminal run **mvn test**