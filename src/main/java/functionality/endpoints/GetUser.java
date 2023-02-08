package main.java.functionality.endpoints;

import static main.java.functionality.SetupEnvironment.buildEnv;

public class GetUser extends EndpointSuper {
    // Constructor without the required query param
    public GetUser(boolean doCall) {
        System.out.println("In Get User endpoint");
        requestSpec = buildEnv();
        url = "/api/users/1";
        if (doCall) {getPayload();}
    }
}
