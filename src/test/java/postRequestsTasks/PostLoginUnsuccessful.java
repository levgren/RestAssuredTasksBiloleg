package postRequestsTasks;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.hasKey;
import static org.hamcrest.Matchers.lessThan;

public class PostLoginUnsuccessful {
    //LOGIN - UNSUCCESSFUL

    private RequestSpecification requestSpecification = new RequestSpecBuilder()
            .setBaseUri("https://reqres.in/")
            .setContentType(ContentType.JSON)
            .setBasePath("/api/login")
            .build();

    private ResponseSpecification responseSpecification = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .expectResponseTime(lessThan(5000L))
            .expectBody("$", hasKey("token"))
            .build();

    @Test
    public void registerPostTest(){
        given()
                .spec(requestSpecification)
                .body("{\"email\": \"peter@klaven\"}")
                .when()
                .post()
                .then()
                .spec(responseSpecification)
                .and()
                .body("token", equalTo("QpwL5tke4Pnpja7X4"));
    }
}
