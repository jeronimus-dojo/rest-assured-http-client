package functionality.endpoints;

import static functionality.SetupEnvironment.buildEnv;

public class DeleteUser extends EndpointSuper{
    public DeleteUser(String userID, boolean doCall) {
        System.out.println("In DELETE User endpoint");
        requestSpec = buildEnv();
        url = "/api/users/" + userID;

        if (doCall) {
            doDELETE();
        }

    }
}
