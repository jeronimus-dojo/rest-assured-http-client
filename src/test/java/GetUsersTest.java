import functionality.endpoints.GetUsers;
import models.getUser.response.UserDataGet;
import models.getUser.response.UsersGet;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GetUsersTest {

    @Test
    public void getAllUsersHappyPath() {
        GetUsers usersHappy = new GetUsers(true);

        usersHappy.writePayload();

        UsersGet usersGetBody = usersHappy.getBody().as(UsersGet.class);
        System.out.println(usersGetBody.getPerPage());
        System.out.println(usersGetBody.getSupport().getText());

        List<UserDataGet> bloop = usersGetBody.getData();

        for (UserDataGet temp : bloop) {
            System.out.println(temp.getFirstName());

        }

        assertThat(usersGetBody.getPerPage(), equalTo(bloop.size()));

    }
}
