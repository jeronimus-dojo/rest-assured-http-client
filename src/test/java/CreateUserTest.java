import functionality.endpoints.CreateUser;
import functionality.endpoints.DeleteUser;
import models.getUser.request.UserPost;
import org.junit.After;
import org.junit.Test;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static java.net.HttpURLConnection.HTTP_CREATED;
import static java.net.HttpURLConnection.HTTP_NO_CONTENT;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class CreateUserTest
{
    @After
    public void deleteCreatedUser() {
        DeleteUser user =  new DeleteUser("100", true);

        assertThat("Got correct HTTP status code", user.getResponse().getStatusCode(), equalTo(HTTP_NO_CONTENT));
    }

    @Test
    public void createUserHappyPath() {
        UserPost body = new UserPost("rest@assured.com", "resting", "full", "https://reqres.in/img/faces/1-image.jpg");
        CreateUser user = new CreateUser(body, true);

        user.writePayload();

        assertThat("Got correct HTTP status code", user.getResponse().getStatusCode(), equalTo(HTTP_CREATED));

        assertThat("JSON Schema is correct", user.getResponse().asString(), matchesJsonSchemaInClasspath("jsonSchema/json_schema_create_user.json"));
    }
}
