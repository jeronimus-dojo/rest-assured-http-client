package functionality.endpoints;

import static functionality.SetupEnvironment.buildEnv;

public class GetUsers extends EndpointSuper{
    public GetUsers(String page, String perPage, boolean doCall) {
        System.out.println("In Get User endpoint");
        requestSpec = buildEnv();
        url = "/api/users?page=" + page + "&per_page=" + perPage;

        if (doCall) {
            doGET();
        }
    }
    public GetUsers(boolean doCall) {
        System.out.println("In Get User endpoint");
        requestSpec = buildEnv();
        url = "/api/users";

        if (doCall) {
            doGET();
        }
    }
}
