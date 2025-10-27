package base.backend;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;


public class baseApi {

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://airportgap.com/api";
    }
}
