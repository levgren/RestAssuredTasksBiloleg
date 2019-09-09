package endpointsTestClasses;

import io.restassured.http.ContentType;
import org.junit.Test;
import specificationns.ApiUsersEndpointSpec;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItem;

public class ApiUsersEndPoint{

    private ApiUsersEndpointSpec apiUsersEndpointSpec = new ApiUsersEndpointSpec();

    //without spec
    @Test
    public void getWithParams(){
        given().baseUri("https://reqres.in/")
                .contentType(ContentType.JSON)
                .basePath("/api/users")  //endpoint
                .param("page", 2)
                .when()
                .get()
                .then()
                .statusCode(200)
                .and()
                .body("data.id", hasItem(7));
    }

    @Test
    public void getParamsWithSpec(){
        given()
                .spec(apiUsersEndpointSpec.requestSpecification)
                .pathParam("id", 7)
                .when()
                .get()
                .then()
                .spec(apiUsersEndpointSpec.responseSpecification)
                .and()
                .body("data.first_name", equalTo("Michael"))
                .and()
                .body("data.last_name", equalTo("Lawson"));
    }

    @Test
    public void getNotFound(){
        given()
                .spec(apiUsersEndpointSpec.requestSpecification)
                .pathParam("id", 23)
                .when()
                .get()
                .then()
                .spec(apiUsersEndpointSpec.responceSpecForWrongStatusCode);
    }

    @Test
    public void postRequestCreate(){
        given()
                .spec(apiUsersEndpointSpec.requestSpecificationForPostCreate)
                .body ("{\"name\": \"Jeka\", \"job\": \"Aureushunter\"}")
                .when()
                .post()
                .then()
                .spec(apiUsersEndpointSpec.responseSpecificationForPostCreate)
                .and()
                .body("name", equalTo("Jeka"))
                .and()
                .body("job", equalTo("Aureushunter"));
    }
}
