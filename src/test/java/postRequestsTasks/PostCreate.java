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

public class PostCreate {

    private RequestSpecification requestSpecification = new RequestSpecBuilder()
            .setBaseUri("https://reqres.in/")
            .setContentType(ContentType.JSON)
            .setBasePath("/api/users")
            .build();

    private ResponseSpecification responseSpecification = new ResponseSpecBuilder()
            .expectStatusCode(201)
            .expectResponseTime(lessThan(3500L))
            .expectBody("$", hasKey("name"))
            .expectBody("$", hasKey("job"))
            .build();

    @Test
    public void postRequestCreate(){
        given()
                .spec(requestSpecification)
                .body ("{\"name\": \"Jeka\", \"job\": \"Aureushunter\"}")
                .when()
                .post()
                .then()
                .spec(responseSpecification)
                .and()
                .body("name", equalTo("Jeka"))
                .and()
                .body("job", equalTo("Aureushunter"));
    }
}
