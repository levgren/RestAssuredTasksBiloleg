package specificationns;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static org.hamcrest.Matchers.hasKey;
import static org.hamcrest.Matchers.lessThan;

public class ApiRegisterEndpointSpec {

    public RequestSpecification requestSpecification = new RequestSpecBuilder()
            .setBaseUri("https://reqres.in/")
            .setContentType(ContentType.JSON)
            .setBasePath("/api/register")
            .build();

    public ResponseSpecification responseSpecificationRegisterUnsuccessful = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .expectResponseTime(lessThan(5000L))
            .expectBody("$", hasKey("id"))
            .expectBody("$", hasKey("token"))
            .build();

    public ResponseSpecification responseSpecification = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .expectResponseTime(lessThan(5000L))
            .expectBody("$", hasKey("email"))
            .expectBody("$", hasKey("password"))
            .build();

}
