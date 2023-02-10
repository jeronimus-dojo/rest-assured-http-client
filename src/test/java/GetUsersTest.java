import functionality.endpoints.GetUsers;
import models.user.UserData;
import models.user.Users;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GetUsersTest {

    @Test
    public void getAllUsersHappyPath() {
        GetUsers usersHappy = new GetUsers(true);

        usersHappy.writePayload();

        Users usersBody = usersHappy.getBody().as(Users.class);
        System.out.println(usersBody.getPerPage());
        System.out.println(usersBody.getSupport().getText());

        List<UserData> bloop = usersBody.getData();

        for (UserData temp : bloop) {
            System.out.println(temp.getFirstName());

        }

        assertThat(usersBody.getPerPage(), equalTo(bloop.size()));

    }
}
