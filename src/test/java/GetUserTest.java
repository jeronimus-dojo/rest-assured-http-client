import functionality.endpoints.GetUser;
import models.getUser.response.UserDataGet;
import models.getUser.response.UserGet;
import org.junit.Test;

import java.util.regex.Pattern;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static java.net.HttpURLConnection.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.text.MatchesPattern.matchesPattern;

public class GetUserTest {

    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    @Test
    public void getUserHappyPath() {
        GetUser user = new GetUser("1", true);
        user.writePayload();

        assertThat("Got the correct HTTP Status code back", HTTP_OK, equalTo(user.getResponse().getStatusCode()));

        assertThat("JSON Schema is correct", user.getResponse().asString(), matchesJsonSchemaInClasspath("jsonSchema/json_schema_get_user.json"));

        // Use POJOs to verify the payload
        UserDataGet UserDataPayload = user.getBody().as(UserGet.class).getData();

        assertThat("First name is as expected","George", equalTo(UserDataPayload.getFirstName()));
        assertThat("First name is as expected","Bluth", equalTo(UserDataPayload.getLastName()));

        assertThat("Email is valid", (UserDataPayload.getEmail()), matchesPattern(VALID_EMAIL_ADDRESS_REGEX));
        assertThat("Email is as expected", "george.bluth@reqres.in", equalTo(UserDataPayload.getEmail()));

        assertThat("Avatar is as expected", "https://reqres.in/img/faces/1-image.jpg", equalTo(UserDataPayload.getAvatar()));
    }

    @Test
    public void getUserThatDoesNotExist() {
        GetUser user = new GetUser("99999", false);
        user.setGetCommonResponseSpec(false);
        user.doGET();

        assertThat(HTTP_NOT_FOUND, equalTo(user.getResponse().getStatusCode()));
    }
}
