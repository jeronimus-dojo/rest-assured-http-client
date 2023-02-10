import functionality.endpoints.CreateUser;
import org.junit.Test;

import static java.net.HttpURLConnection.HTTP_CREATED;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class CreateUserTest
{
    @Test
    public void createUserHappyPath() {
        CreateUser userHappy = new CreateUser(true);

        userHappy.writePayload();

        assertThat(HTTP_CREATED, equalTo(userHappy.getResponse().getStatusCode()));
    }
}
