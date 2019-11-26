package endpointsTestClasses;

import org.junit.Test;
import specificationns.ApiLoginEndpointSpec;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class ApiLoginEndPoint {

    private ApiLoginEndpointSpec apiLoginEndpointSpec = new ApiLoginEndpointSpec();

    @Test
    public void loginSuccessfulPostTest(){
        given()
                .spec(apiLoginEndpointSpec.requestSpecification)
                .body("{\"email\": \"eve.holt@reqres.in\", \"password\": \"cityslicka\"}")
                .when()
                .post()
                .then()
                .spec(apiLoginEndpointSpec.responseSpecification)
                .and()
                .body("token", equalTo("QpwL5tke4Pnpja7X4"));
        System.out.println("==========================================");

    }

    @Test
    public void loginUnsuccessfulPostTest(){
        given()
                .spec(apiLoginEndpointSpec.requestSpecification)
                .body("{\"email\": \"peter@klaven\"}")
                .when()
                .post()
                .then()
                .spec(apiLoginEndpointSpec.responseSpecification)
                .and()
                .body("token", equalTo("QpwL5tke4Pnpja7X4"));
    }
}
