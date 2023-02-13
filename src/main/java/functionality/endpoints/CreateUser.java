package functionality.endpoints;

import models.getUser.request.UserPost;

import static functionality.SetupEnvironment.buildEnv;

public class CreateUser extends EndpointSuper {
    public CreateUser(UserPost body, boolean doCall) {
        System.out.println("In Create User endpoint");

        requestSpec = buildEnv();
        requestSpec.body(body);
        url = "/api/users/";

        if (doCall) {
            doPOST();}
    }
}
