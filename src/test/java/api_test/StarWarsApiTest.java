package api_test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static io.restassured.RestAssured.when;
import static org.hamcrest.CoreMatchers.equalTo;

public class StarWarsApiTest {
    Logger log = LoggerFactory.getLogger(StarWarsApiTest.class);

    @BeforeEach
    public void setUp() {
        RestAssured.baseURI = "https://swapi.dev/api";
    }


    @Test
    public Response getShipInfo() {
        Response response = RestAssured.get("/starships/10");
        return response;
    }

    @Test
    public void checkShipNameTest() {
         getShipInfo().then()
                .log().body()
                .statusCode(200)
                .assertThat()
                .body("name", equalTo("Millennium Falcon"));
    }

    @Test
    public void checkShipCostInCreditsTest() {
        getShipInfo().then()
                .log().body()
                .statusCode(200)
                .assertThat()
                .body("cost_in_credits", equalTo("100000"));
    }

    @Test
    public void checkShipLengthTest() {
        getShipInfo().then()
                .log().body()
                .statusCode(200)
                .assertThat()
                .body("length", equalTo("34.37"));
    }

    @Test
    public void checkShipPilotsQuantityTest() {
        getShipInfo().then()
                .log().body()
                .statusCode(200)
                .assertThat()
                .body("pilots.size()", equalTo(4));
    }
}
