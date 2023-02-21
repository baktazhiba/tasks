package apiTasks;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UsersApi {

    public static void main(String[] args) throws JsonProcessingException {

        Response response = given()
                .when()
                .get("https://jsonplaceholder.typicode.com/users")
                .then()
                .extract().response();

        ObjectMapper mapper = new ObjectMapper();

        JsonNode node = mapper.readTree(response.getBody().asString());

        node.forEach(user -> {
            System.out.println("=========================");
            System.out.println("Address: ");
            JsonNode address = null;
            address = user.get("address");

            address.forEach(property -> {
                System.out.println("Street: " + property.get("street"));
                System.out.println("City: " + property.get("city"));
            });
            System.out.println("=========================");
        });
    }
}
