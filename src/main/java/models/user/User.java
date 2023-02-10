package models.user;

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
public class User {

    @JsonProperty("data")
    private UserData userData;
    @JsonProperty("support")
    private Support support;

    /**
     * No args constructor for use in serialization
     *
     */
    public User() {
    }

    /**
     *
     * @param userData
     * @param support
     */
    public User(UserData userData, Support support) {
        super();
        this.userData = userData;
        this.support = support;
    }

    @JsonProperty("data")
    public UserData getData() {
        return userData;
    }

    @JsonProperty("data")
    public void setData(UserData userData) {
        this.userData = userData;
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