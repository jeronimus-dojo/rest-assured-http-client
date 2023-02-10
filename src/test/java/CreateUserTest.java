import functionality.endpoints.CreateUser;
import org.junit.Test;

public class CreateUserTest
{
    @Test
    public void createUserHappyPath() {
        CreateUser userHappy = new CreateUser(true);

        userHappy.writePayload();

    }
}
