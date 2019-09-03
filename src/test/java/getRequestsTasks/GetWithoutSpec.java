package getRequestsTasks;

import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.hasItem;

public class GetWithoutSpec {
    //without spec
    @Test
    public void getWithParams(){
        given().baseUri("https://reqres.in/")
                .contentType(ContentType.JSON)
                .basePath("/api/users")
                .param("page", 2)
                .when()
                .get()
                .then()
                .statusCode(200)
                .and()
                .body("data.id", hasItem(7));
    }
}
