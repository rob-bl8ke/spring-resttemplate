## Page Object

- [Source Video](https://www.udemy.com/course/spring-framework-6-beginner-to-guru/learn/lecture/35267264#questions)

The client (`BeerClientImpl`) will be consuming the API exposed by [the VS Code Beer Solution](https://github.com/rob-bl8ke/prototype-beer-app). This API uses the `Page` generic object from `org.springframework.data.domain.Page` and so in order to work with the response the following dependency is added:
```xml
<dependency>
    <groupId>org.springframework.data</groupId>
    <artifactId>spring-data-commons</artifactId>
</dependency>
```
This is simply to provide consistency between the two projects. The JSON returned is easily serialized to the same object. This is possible because both projects are Spring Boot projects.

# `RestTemplateBuilder` and `RestTemplate`

These examples offer alternate methods to use `RestTemplate` to retrieve data from via HTTP request. These alternate approaches can be tested in the `BeerClientImpl` class.

```java
    // Simply return response as a JSON string
    ResponseEntity<String> stringResponse = restTemplate.getForEntity(BASE_URL + GET_BEER_PATH, String.class);
    System.out.println((stringResponse.getBody()));

    // Use a map to get data back in a semi-structured form. Good approach if not sure what is being returned by the API
    // and would simply want to interrogate the information coming back.
    ResponseEntity<Map> mapResponse = restTemplate.getForEntity(BASE_URL + GET_BEER_PATH, Map.class);

    // Parse content using Jackson to fetch the content that you need.
    ResponseEntity<JsonNode> jsonResponse = restTemplate.getForEntity(BASE_URL + GET_BEER_PATH, JsonNode.class);
    jsonResponse.getBody().findPath("content").elements().forEachRemaining(node -> {
        System.out.println(node.get("beerName").asText());
    });
```
