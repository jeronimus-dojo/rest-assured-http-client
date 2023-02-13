import functionality.endpoints.CreateUser;
import functionality.endpoints.DeleteUser;
import models.getUser.request.UserPost;
import org.junit.Before;
import org.junit.Test;

import static java.net.HttpURLConnection.HTTP_CREATED;
import static java.net.HttpURLConnection.HTTP_NO_CONTENT;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class DeleteUserTest {

    @Before
    public void createUserToDelete() {
        UserPost body = new UserPost(100, "rest@assured.com", "resting", "full", "https://reqres.in/img/faces/1-image.jpg");
        CreateUser userHappy = new CreateUser(body, true);

        assertThat("Got correct HTTP status code", userHappy.getResponse().getStatusCode(), equalTo(HTTP_CREATED));
    }

    @Test
    public void  deleteUserHappyPath() {
        DeleteUser userDelete =  new DeleteUser("100", true);

        assertThat("Got correct HTTP status code", userDelete.getResponse().getStatusCode(), equalTo(HTTP_NO_CONTENT));

    }
}