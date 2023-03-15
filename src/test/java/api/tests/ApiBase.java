package api.tests;

import api.EndPoint;
import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.asynchttpclient.Request;

import java.util.Random;

public class ApiBase {
    protected Faker faker = new Faker();

    final String BASE_URI = "http://phonebook.telran-edu.de:8080";
    final String API_KEY = "eyJhbGciOiJIUzUxMiJ9.eyJ1c2VybmFtZSI6InRlc3RAZ21haWwuY29tIiwiYXV0aG9yaXRpZXMiOlsiUk9MRV9VU0VSIl0sImV4cCI6MjEwNjk3ODI5Nn0.GM1wsoRV2QoAsD6wKmIk7N49DDpuCejK4BC9H9YItJvesH5vft8HO2uqTPnGQJwJ5oXKS2OILqP1yoanMnIMkA";

    RequestSpecification spec = new RequestSpecBuilder()
            .setBaseUri(BASE_URI)
            .setContentType(ContentType.JSON)
            .addHeader("Access-Token", API_KEY)
            .build();
    public Response doPostRequest(Object body, EndPoint endPoint, int statusCode) {
        return RestAssured.given()
                .spec(spec)
                .body(body)
                .when()
                .log().all()
                .post(endPoint.getValue())
                .then()
                .statusCode(statusCode)
                .log().all()
                .extract().response();

    }

public Response doDeleteRequest(int id, EndPoint endPoint, int statusCode) {
        return RestAssured.given()
                .spec(spec)
                .when()
                .pathParams("id", id)
                .log().all()
                .delete(endPoint.getValue())
                .then()
                .statusCode(statusCode)
                .log().all()
                .extract().response();

    }
    public int getWrongId(){
        Random rnd =new Random();
        return 100000 + rnd.nextInt(900000);
    }


}
