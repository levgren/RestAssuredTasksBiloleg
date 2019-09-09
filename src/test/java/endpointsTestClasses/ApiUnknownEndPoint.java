package endpointsTestClasses;

import io.restassured.response.ValidatableResponse;
import org.junit.Test;
import specificationns.ApiUnknownEndpointSpec;
import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class ApiUnknownEndPoint {

    private ApiUnknownEndpointSpec apiUnknownEndpointSpec = new ApiUnknownEndpointSpec();

    //посчитать количество обьектов в data и сравнить со значением в per_page
    @Test   //#4
    public void checkQuantityOfDataOnThePage(){
        ValidatableResponse validatableResponse = given()
                .spec(apiUnknownEndpointSpec.requestSpecification)
                .when()
                .get()
                .then()
                .spec(apiUnknownEndpointSpec.responseSpecification);
        validatableResponse.body("data.size()", equalTo(validatableResponse.extract().path("per_page")));
    }

    //    проверить что в data только 1 обьект и проверить value всех полей
    @Test   //#5
    public void checkThatDataContainSingleObject(){
        given()
                .spec(apiUnknownEndpointSpec.requestSpecificationForFifthTask)
                .when()
                .get()
                .then()
                .spec(apiUnknownEndpointSpec.responseSpecification)
                .and()
                .body("data.id", equalTo(2))
                .and()
                .body("data.name", equalTo("fuchsia rose"))
                .and()
                .body("data.year", equalTo(2001))
                .and()
                .body("data.color", equalTo("#C74375"))
                .and()
                .body("data.pantone_value", equalTo("17-2031"));
    }

    // #6 check that status code = 200
    @Test
    public void checkStatusCode(){
        given()
                .spec(apiUnknownEndpointSpec.requestSpecificationForCheckingCOde)
                .when()
                .get()
                .then()
                .spec(apiUnknownEndpointSpec.responseSpecification);
    }
}
