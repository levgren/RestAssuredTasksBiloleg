package specificationns;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static org.hamcrest.Matchers.hasKey;
import static org.hamcrest.Matchers.lessThan;

public class ApiUnknownEndpointSpec {

    public RequestSpecification requestSpecification = new RequestSpecBuilder()
            .setBaseUri("https://reqres.in/")
            .setContentType(ContentType.JSON)
            .setBasePath("/api/unknown")
            .build();

    public RequestSpecification requestSpecificationForFifthTask = new RequestSpecBuilder()
            .setBaseUri("https://reqres.in/")
            .setContentType(ContentType.JSON)
            .setBasePath("/api/unknown/2")
            .build();

    public RequestSpecification requestSpecificationForCheckingCOde = new RequestSpecBuilder()
            .setBaseUri("https://reqres.in/")
            .setContentType(ContentType.JSON)
            .setBasePath("/api/unknown/23")
            .build();

    public ResponseSpecification responseSpecification = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .expectResponseTime(lessThan(5000L))
            .build();
}
