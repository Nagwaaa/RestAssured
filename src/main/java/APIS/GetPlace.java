package APIS;

import io.restassured.RestAssured;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
public class GetPlace {


    @Test
    public void getPlaceApi()
    {
        RestAssured.baseURI="https://rahulshettyacademy.com";
        given().queryParam("key","qaclick123").queryParam("place_id","7cd998fbdc82fcbec729c9ea58cddf7a")
                .when().get("maps/api/place/get/json")
                .then().log().all().assertThat().statusCode(200);
    }
}
