package com.example.zajecia2.IntegrationTests;

import com.example.zajecia2.model.Auto;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.jdbc.Sql;

import static io.restassured.RestAssured.basePath;
import static org.hamcrest.Matchers.is;

@Sql(scripts={"insertAuto.sql"},executionPhase = Sql.ExecutionPhase.BEFORE_TEST_CLASS)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MyIntegrationTest {

    @LocalServerPort
    int port;

    @BeforeEach
    public void setUp() {
        RestAssured.port = port;
    }


    @Test
    public void test1() {
        RestAssured.get(basePath + "/auta/all")
                .then()
                .statusCode(200)
                .body("$.size()", is(3));

    }

    @Test
    public void test2() {
        RestAssured.with().body(new Auto("toyota",1999))
                .header("Content-Type", "application/json")
                .when()
                .post("http://localhost:8081/autoo/dodaj")
                .then()
                .statusCode(201);

    }
    @Test
    public void test3(){


    }
}
