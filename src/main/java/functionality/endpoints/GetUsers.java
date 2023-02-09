package functionality.endpoints;

import static functionality.SetupEnvironment.buildEnv;

public class GetUsers extends EndpointSuper{
    public GetUsers(boolean doCall) {
        System.out.println("In Get User endpoint");
        requestSpec = buildEnv();
        url = "/api/users?page=1&per_page=5";

        if (doCall) {
            doGET();
        }

    }
}
