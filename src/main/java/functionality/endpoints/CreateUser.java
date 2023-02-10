package functionality.endpoints;

import static functionality.SetupEnvironment.buildEnv;

public class CreateUser extends EndpointSuper {
    public CreateUser(String userID, boolean doCall) {
        System.out.println("In Create User endpoint");
        requestSpec = buildEnv();
        url = "/api/users/" + userID;
        if (doCall) {
            doGET();}
    }
}
