package functionality.endpoints;

import models.request.User;

import static functionality.SetupEnvironment.buildEnv;

public class CreateUser extends EndpointSuper {
    public CreateUser(boolean doCall) {
        System.out.println("In Create User endpoint");
        requestSpec = buildEnv();
        User body = new User(100, "rest@assured.com", "resting", "full", "https://reqres.in/img/faces/1-image.jpg");
        requestSpec.body(body);
        url = "/api/users/" + 100;
        if (doCall) {
            doPOST();}
    }
}
