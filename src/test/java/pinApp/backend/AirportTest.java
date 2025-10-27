package pinApp.backend;

import base.backend.airportsEndpoint;
import base.backend.baseApi;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class AirportTest extends baseApi {

    private String readJsonFromFile() throws IOException {
        return new String(Files.readAllBytes(Paths.get("src/test/resources/requestBodies/distanceRequest.json")));
    }

    @Test(description = "Valida obtención de aeropuertos", priority = 1)
    public void testGetAirports() {

        given()
                .contentType(ContentType.JSON)
                .when()
                .get("/airports")
                .then()
                .log()
                .all()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("data", not(empty()))
                .body("data[0].attributes.name", notNullValue());

        Response response = airportsEndpoint.getAirports();
        response.then().statusCode(200);

        Assert.assertFalse(response.jsonPath().getList("data").isEmpty(), "La lista de aeropuertos no debería estar vacía");
    }

    @Test(description = "Calcula la distancia entre 2 aeropuertos",priority = 2)
    public void distanceBetweenAirports() throws IOException {

        String requestBody = readJsonFromFile();

        given()
                .contentType(ContentType.JSON)
                .body(requestBody)

                .when()
                .post("/airports/distance")
                .then()
                .log()
                .all()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("data.attributes.kilometers", greaterThan(0f))
                .body("data.attributes.miles", greaterThan(0f))
                .body("data.attributes.from_airport.name", notNullValue())
                .body("data.attributes.to_airport.name", notNullValue());
    }
}
