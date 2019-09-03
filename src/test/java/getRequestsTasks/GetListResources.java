package getRequestsTasks;

import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.hasItem;

public class GetListResources {

    //LIST <RESOURCE>
    @Test
    public void listResources(){
        given()
                .baseUri("https://reqres.in/")
                .contentType(ContentType.JSON)
                .basePath("/api/unknown")
                .param("page", 2)
                .when()
                .get()
                .then()
                .statusCode(200)
                .and()
                .body("name", hasItem("cerulean"));
//                .and()
//                .body("year", hasItem(2000));

    }
}
