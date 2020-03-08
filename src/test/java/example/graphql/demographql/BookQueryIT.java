package example.graphql.demographql;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static java.util.stream.Collectors.toList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.equalTo;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BookQueryIT {
    @LocalServerPort
    private Integer port;

    @BeforeEach
    public void setup() {
        RestAssured.port = port;
        RestAssured.baseURI = "http://localhost";
    }

    @Test
    public void shouldReturnABookById() {
        List<Map<String, String>> payload =
            given()
                .body("{\"query\":\"{\\n allBooks { \\n name\\n }\\n }\\n  \" }")
                .contentType("application/json")
            .when()
                .post("/graphql")
            .then()
                .statusCode(200)
                .body("data.allBooks.size", equalTo(3))
                .extract().jsonPath().getList("data.allBooks");

        List<String> names = payload.stream().map( map -> map.values().iterator().next()).collect(toList());
        assertThat(names, containsInAnyOrder("Harry Potter and the Philosophers Stone","Moby Dick","Interview with the vampire"));
    }
}
