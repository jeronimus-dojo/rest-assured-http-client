package functionality;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;

import static java.net.HttpURLConnection.HTTP_OK;

public class ResponseSpecs {

    public static ResponseSpecification getCommonResponseSpec(){
        return new ResponseSpecBuilder().
                expectStatusCode(200).
                expectContentType(ContentType.JSON).
                build();
    }
}
