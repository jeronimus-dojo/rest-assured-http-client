import functionality.endpoints.PutUser;
import models.getUser.request.UserPut;
import org.junit.Test;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static java.net.HttpURLConnection.HTTP_OK;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class PutUserTest {

    @Test
    public void updateUserHappyPath() {
        UserPut body = new UserPut("Clarence Hall", "Backend Tester");
        PutUser user = new PutUser("1", body, true);

        user.writePayload();

        assertThat("Got correct HTTP status code", user.getResponse().getStatusCode(), equalTo(HTTP_OK));

        assertThat("JSON Schema is correct", user.getResponse().asString(), matchesJsonSchemaInClasspath("jsonSchema/json_schema_put_user.json"));
    }
}
