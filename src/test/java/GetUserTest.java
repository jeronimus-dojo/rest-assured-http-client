import functionality.endpoints.GetUser;
import models.response.UserData;
import models.response.User;
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

        User userBody = userHappy.getBody().as(User.class);

        assertThat("George", equalTo(userBody.getData().getFirstName()));
        assertThat("Bluth", equalTo(userBody.getData().getLastName()));


        assertThat((userBody.getData().getEmail()), matchesPattern(VALID_EMAIL_ADDRESS_REGEX));

        assertThat(HTTP_OK, equalTo(userHappy.getResponse().getStatusCode()));

        UserData test = new UserData(1, "hello", "there", "this", "nice");
        System.out.println( test );
    }

    @Test
    public void getUserThatDoesNotExist() {
        GetUser userNotExist = new GetUser("a", false);
        userNotExist.setGetCommonResponseSpec(false);
        userNotExist.doGET();



        assertThat(HTTP_NOT_FOUND, equalTo(userNotExist.getResponse().getStatusCode()));
    }

}
