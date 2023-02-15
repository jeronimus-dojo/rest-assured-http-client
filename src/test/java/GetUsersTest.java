import functionality.endpoints.GetUsers;
import models.getUser.response.UserDataGet;
import models.getUser.response.UsersGet;
import org.junit.Test;

import java.util.List;

import static java.net.HttpURLConnection.HTTP_OK;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GetUsersTest {

    @Test
    public void getUsersWithValidPageAndPerPage() {
        int page = 1;
        int perPage = 5;

        GetUsers users = new GetUsers(Integer.toString(page), Integer.toString(perPage), true);
        assertThat("Got the correct HTTP Status code back", HTTP_OK, equalTo(users.getResponse().getStatusCode()));

        users.writePayload();

        UsersGet usersPayload = users.getBody().as(UsersGet.class);

        assertThat("Got the correct page back", page, equalTo(usersPayload.getPage()));
        assertThat("Got the correct per_page back", perPage, equalTo(usersPayload.getPerPage()));

        List<UserDataGet> usersList = usersPayload.getData();
        assertThat("Correct number of users were returned", perPage, equalTo(usersList.size()));

        for (UserDataGet temp : usersList) {
            System.out.println(temp.getFirstName());
        }
    }
    @Test
    public void getUsersWithNoPageAndPerPage() {
        GetUsers users = new GetUsers(true);
        assertThat("Got the correct HTTP Status code back", HTTP_OK, equalTo(users.getResponse().getStatusCode()));

        users.writePayload();

        UsersGet usersPayload = users.getBody().as(UsersGet.class);

        List<UserDataGet> usersList = usersPayload.getData();
        assertThat("Number of users were returned matches per_page in payload", usersPayload.getPerPage(), equalTo(usersList.size()));
    }
}
