package functionality.endpoints;

import static functionality.SetupEnvironment.buildEnv;

public class GetUsers extends EndpointSuper{
    // GetUsers with page and perPage
    public GetUsers(String page, String perPage, boolean doCall) {
        System.out.println("In Get User endpoint");
        requestSpec = buildEnv();
        url = "/api/users?page=" + page + "&per_page=" + perPage;

        if (doCall) {
            doGET();
        }
    }

    // GetUsers with no query string
    public GetUsers(boolean doCall) {
        System.out.println("In Get User endpoint");
        requestSpec = buildEnv();
        url = "/api/users";

        if (doCall) {
            doGET();
        }
    }
}
