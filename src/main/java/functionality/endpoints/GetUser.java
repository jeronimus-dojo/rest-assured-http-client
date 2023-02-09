package functionality.endpoints;

import static functionality.SetupEnvironment.buildEnv;

public class GetUser extends EndpointSuper {
    public GetUser(String userID, boolean doCall) {
        System.out.println("In Get User endpoint");
        requestSpec = buildEnv();
        url = "/api/users/" + userID;
        if (doCall) {
            doGET();}
    }
}
