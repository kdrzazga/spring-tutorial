package org.kd.springbootrest.demo;

import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

@SpringBootTest
public class ControllerTest {

    @Test
    public void testUsingResponseEntityBuilderAndHttpHeaders() {
        RestAssured.given()
                .auth().basic("playero", "pass")
                .when().get("http://localhost:8080/response-entity-builder-with-http-headers")
                .then().statusCode(HttpStatus.OK.value())
                .and().headers("KD-Header","Value-ResponseEntityBuilderWithHttpHeaders")
                .and().body(Matchers.containsString("Response with header using ResponseEntity"));
    }
}
