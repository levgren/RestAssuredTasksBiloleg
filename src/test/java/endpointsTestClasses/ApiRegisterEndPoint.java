package endpointsTestClasses;

import org.junit.Test;
import specificationns.ApiRegisterEndpointSpec;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class ApiRegisterEndPoint {

    private ApiRegisterEndpointSpec apiRegisterEndpointSpec = new ApiRegisterEndpointSpec();

    @Test
    public void registerPostTest(){
        given()
                .spec(apiRegisterEndpointSpec.requestSpecification)
                .body("{\"email\": \"eve.holt@reqres.in\", \"password\": \"pistol\"}")
                .when()
                .post()
                .then()
                .spec(apiRegisterEndpointSpec.responseSpecification)
                .and()
                .body("id", equalTo(4))
                .and()
                .body("token", equalTo("QpwL5tke4Pnpja7X4"));
    }

    @Test
    public void registerUnsuccessfulPostTest(){
        given()
                .spec(apiRegisterEndpointSpec.requestSpecification)
                .body("{\"email\": \"sydney@fife\"}")
                .when()
                .post()
                .then()
                .spec(apiRegisterEndpointSpec.responseSpecificationRegisterUnsuccessful)
                .and()
                .body("id", equalTo(4))
                .and()
                .body("token", equalTo("QpwL5tke4Pnpja7X4"));
    }
}
