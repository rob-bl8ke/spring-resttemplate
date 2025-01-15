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


> 





I'm running into problems trying to run my Spring Boot project in VS Code. It was working fine but I moved the solution folder and renamed the folder. Now I'm getting the following error when I try to run the project through either the Spring Boot Dashboard or via the run and debug configuration (VS Code launch.json).

I then reopened the folder in VS Code.

The issue I get when attempting the run is: "ConfigError: The project 'project-name' is not a valid java project."

When I look at the "Problems" pane, I see the following errors:

"No implementation was created for [class-name]Mapper due to having a problem in the erroneous element java.util.ArrayList. Hint: this often means that some other annotation processor was supposed to process the erroneous element. You can also enable MapStruct verbose mode by setting -Amapstruct.verbose=true as a compilation argument."

I'm not sure if these problems are related, but Maven cleans, compiles, and runs tests and integration tests without a problem. Do you have any idea what could be wrong?


