package test.java;

import main.java.functionality.endpoints.GetUser;
import org.junit.Test;

import static java.net.HttpURLConnection.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GetUserTest {

    @Test
    public void getOrders(){
        GetUser user = new GetUser(true);

        assertThat(HTTP_OK, equalTo(user.getResponse().getStatusCode()));
    }
}
