package functionality.endpoints;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.RequestSpecification;

import java.io.FileWriter;
import java.io.IOException;

import static io.restassured.RestAssured.given;
import static functionality.ResponseSpecs.getCommonResponseSpec;

public class EndpointSuper {
    protected RequestSpecification requestSpec;
    private Response payload = null;
    private ResponseBody body = null;
    private JsonPath payloadJson = null;
    private Boolean getCommonResponseSpec = true;
    protected String url;

    public void doGET(){
        requestSpec.log().everything(false);
        requestSpec.log().ifValidationFails();
        payload  =  given().
                        spec(requestSpec).
                        log().all().
                    when().
                        get(url); // can't do any more method chaining as payload needs a Response returned to it
        payloadJson = new JsonPath(payload.asString());
        runCommonResponseSpec();
    }

    public void doPOST(){
        requestSpec.log().everything(true);
        payload =   given().
                        spec(requestSpec).
                        log().all().
                    when().
                        post(url);
        payloadJson = new JsonPath(payload.asString());
    }

    public void doDELETE(){
        requestSpec.log().headers();
        payload =   given().
                        spec(requestSpec).
                        log().all().
                    when().
                        delete(url);
        payloadJson = new JsonPath(payload.asString());
    }

    public JsonPath getPayloadJson(){
        return this.payloadJson;
    }
    public Response getResponse(){
        return this.payload;
    }
    public ResponseBody getBody() { return this.payload.getBody(); }
    public void setGetCommonResponseSpec(boolean setTo) {getCommonResponseSpec = setTo;}

    private void runCommonResponseSpec() {
        if (getCommonResponseSpec) {
            System.out.println("Verifying Common Response Spec");
            this.payload.then().spec(getCommonResponseSpec()); // validate against common expected response
        }
    }

    // Removes request Header headerName from the requestSpec
    public void removeHeader(String headerName) {
        FilterableRequestSpecification filterableRequestSpecification = (FilterableRequestSpecification) requestSpec;
        filterableRequestSpecification.removeHeader(headerName);
    }

    public void writePayload() {
        try (FileWriter file = new FileWriter("E:\\Selenium\\Java\\response_A.json")) {
            file.write(payloadJson.prettyPrint());
            file.flush();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
