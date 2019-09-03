package getRequestsTasks;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetWrongStatusCode {
    //SINGLE USER NOT FOUND
    private RequestSpecification requestSpecCode = new RequestSpecBuilder()
            .setBaseUri("https://reqres.in/")
            .setContentType(ContentType.JSON)
            .setBasePath("/api/users/{id}")
            .build();

    private ResponseSpecification responceSpec = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .build();

    @Test
    public void getNotFound(){
        given()
                .spec(requestSpecCode)
                .pathParam("id", 23)
                .when()
                .get()
                .then()
                .spec(responceSpec);
    }
}
