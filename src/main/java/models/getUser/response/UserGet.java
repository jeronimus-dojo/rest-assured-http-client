package models.getUser.response;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import models.Support;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "data",
        "support"
})
@Generated("jsonschema2pojo")
public class UserGet {

    @JsonProperty("data")
    private UserDataGet userDataGet;
    @JsonProperty("support")
    private Support support;

    /**
     * No args constructor for use in serialization
     *
     */
    public UserGet() {
    }

    /**
     *
     * @param userDataGet
     * @param support
     */
    public UserGet(UserDataGet userDataGet, Support support) {
        super();
        this.userDataGet = userDataGet;
        this.support = support;
    }

    @JsonProperty("data")
    public UserDataGet getData() {
        return userDataGet;
    }

    @JsonProperty("data")
    public void setData(UserDataGet userDataGet) {
        this.userDataGet = userDataGet;
    }

    @JsonProperty("support")
    public Support getSupport() {
        return support;
    }

    @JsonProperty("support")
    public void setSupport(Support support) {
        this.support = support;
    }

}