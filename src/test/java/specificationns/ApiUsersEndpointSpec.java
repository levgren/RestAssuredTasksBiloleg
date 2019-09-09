package specificationns;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static org.hamcrest.Matchers.hasKey;
import static org.hamcrest.Matchers.lessThan;

public class ApiUsersEndpointSpec {

    public RequestSpecification requestSpecification = new RequestSpecBuilder()
            .setBaseUri("https://reqres.in/")
            .setContentType(ContentType.JSON)
            .setBasePath("/api/users/{id}")
            .build();

    public RequestSpecification requestSpecificationForPostCreate = new RequestSpecBuilder()
            .setBaseUri("https://reqres.in/")
            .setContentType(ContentType.JSON)
            .setBasePath("/api/users")
            .build();

    public ResponseSpecification responseSpecification = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .expectResponseTime(lessThan(3000L))
            .expectBody("$", hasKey("data"))
            .build();

    public ResponseSpecification responceSpecForWrongStatusCode = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .build();

    public ResponseSpecification responseSpecificationForPostCreate = new ResponseSpecBuilder()
            .expectStatusCode(201)
            .expectResponseTime(lessThan(3500L))
            .expectBody("$", hasKey("name"))
            .expectBody("$", hasKey("job"))
            .build();
}
