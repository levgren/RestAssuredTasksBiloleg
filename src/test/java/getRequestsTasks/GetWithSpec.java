package getRequestsTasks;

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

public class GetWithSpec {
    //with spec, by id
    private RequestSpecification requestSpecification = new RequestSpecBuilder()
            .setBaseUri("https://reqres.in/")
            .setContentType(ContentType.JSON)
            .setBasePath("/api/users/{id}")
            .build();

    private ResponseSpecification responseSpecification = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .expectResponseTime(lessThan(3000L))
            .expectBody("$", hasKey("data"))
            .build();

    @Test
    public void getParamsWithSpec(){
        given()
                .spec(requestSpecification)
                .pathParam("id", 7)
                .when()
                .get()
                .then()
                .spec(responseSpecification)
                .and()
                .body("data.first_name", equalTo("Michael"))
                .and()
                .body("data.last_name", equalTo("Lawson"));
    }
}
