package test.java;

import functionality.endpoints.GetUser;
import models.User;
import org.junit.Test;

import static java.net.HttpURLConnection.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GetUserTest {

    @Test
    public void getUser(){
        GetUser user = new GetUser(true);
        user.writePayload();

        User user1 = user.getBody().as(User.class);
        System.out.println( user1.getData().getFirstName() );

        assertThat(HTTP_OK, equalTo(user.getResponse().getStatusCode()));
    }
}
