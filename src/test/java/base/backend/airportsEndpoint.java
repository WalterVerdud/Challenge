package base.backend;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class airportsEndpoint {

    public static Response getAirports() {
        return given()
                .when()
                .get("/airports")
                .then()
                .extract()
                .response();
    }

    public static Response calculateDistance(DistanceRequest body) {
        return given()
                .header("Content-Type", "application/json")
                .body(body)
                .when()
                .post("/airports/distance")
                .then()
                .extract()
                .response();
    }


}
