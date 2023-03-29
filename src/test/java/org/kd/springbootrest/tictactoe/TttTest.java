package org.kd.springbootrest.tictactoe;

import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

@SpringBootTest
public class TttTest {

    @Test
    public void testCoordsPlayerO() {
        String coordinates = "1, 1";
        RestAssured.given()
                .auth().basic("playero", "pass")
                .when().get("http://localhost:8080/place/" + coordinates.replaceAll(" ", ""))
                .then().statusCode(HttpStatus.OK.value())
                .and().body(Matchers.containsString(coordinates));
    }

    @Test
    public void testCoordsPlayerX() {
        String coordinates = "3, 2";
        RestAssured.given()
                .auth().basic("playerx", "pass")
                .when().get("http://localhost:8080/place/" + coordinates.replaceAll(" ", ""))
                .then().statusCode(HttpStatus.OK.value())
                .and().body(Matchers.containsString(coordinates));
    }
}
