import functionality.endpoints.GetUser;
import models.getUser.response.UserDataGet;
import models.getUser.response.UserGet;
import org.junit.Test;

import java.util.regex.Pattern;

import static java.net.HttpURLConnection.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.text.MatchesPattern.matchesPattern;

public class GetUserTest {

    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    @Test
    public void getUserHappyPath() {
        GetUser userHappy = new GetUser("1", true);

        userHappy.writePayload();

        UserGet userGetBody = userHappy.getBody().as(UserGet.class);

        assertThat("George", equalTo(userGetBody.getData().getFirstName()));
        assertThat("Bluth", equalTo(userGetBody.getData().getLastName()));


        assertThat((userGetBody.getData().getEmail()), matchesPattern(VALID_EMAIL_ADDRESS_REGEX));

        assertThat(HTTP_OK, equalTo(userHappy.getResponse().getStatusCode()));

        UserDataGet test = new UserDataGet(1, "hello", "there", "this", "nice");
        System.out.println( test );
    }

    @Test
    public void getUserThatDoesNotExist() {
        GetUser userNotExist = new GetUser("99999", false);
        userNotExist.setGetCommonResponseSpec(false);
        userNotExist.doGET();



        assertThat(HTTP_NOT_FOUND, equalTo(userNotExist.getResponse().getStatusCode()));
    }

}
