package APIS;


import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;

import static files.payload.getPayload;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class AddPlace {

    @Test
    public void addPlaceAPI()
    {
        RestAssured.baseURI="https://rahulshettyacademy.com";
       String resp= given().queryParam("key","qaclick123").header("Content-Type","application/json")
                .body(getPayload())
        .when().post("maps/api/place/add/json")
        .then().log().all().assertThat().statusCode(200).body("scope",equalTo("APP")).extract().asString();

        JsonPath js=new JsonPath(resp);
        String placid=js.get("place_id");
        System.out.println(placid);
    }
}
