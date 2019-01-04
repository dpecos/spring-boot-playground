package com.danielpecos.springbootplayground;

import io.restassured.RestAssured;
import org.apache.http.HttpStatus;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SecurityWebTests {

    @Value("${local.server.port}")
    private int localServerPort;

    @Before
    public void setup() {
        RestAssured.port = localServerPort;
    }

    @Test
    public void checkOpenAccessToActuatorHealth() {
        get("/actuator/health").then().assertThat().body("status", equalTo("UP"));
    }

    @Test
    public void checkOpenAccessToActuatorInfo() {
        get("/actuator/info").then().assertThat().statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void checkAuthAccessToAppWithoutCredentials() {
        get("/games").then().assertThat().statusCode(HttpStatus.SC_UNAUTHORIZED);
    }

    @Test
    public void checkAuthAccessToAppWithCredentials() {
        RestAssured.basic("user", "password");
        get("/games").then().assertThat().statusCode(HttpStatus.SC_UNAUTHORIZED);
        RestAssured.reset();
    }
}
