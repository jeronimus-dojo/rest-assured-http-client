package functionality.endpoints;

import models.getUser.request.UserPut;

import static functionality.SetupEnvironment.buildEnv;

public class PutUser extends EndpointSuper{
    public PutUser(String userID, UserPut body, boolean doCall) {
        System.out.println("In PUT User endpoint");

        requestSpec = buildEnv();
        requestSpec.body(body);
        url = "/api/users/" + userID;

        if (doCall) {
            doPUT();
        }
    }
}
