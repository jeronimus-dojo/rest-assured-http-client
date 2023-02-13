package models.getUser.request;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "email",
        "first_name",
        "last_name",
        "avatar"
})
@Generated("jsonschema2pojo")
public class UserPost {

    @JsonProperty("email")
    public String email;
    @JsonProperty("first_name")
    public String firstName;
    @JsonProperty("last_name")
    public String lastName;
    @JsonProperty("avatar")
    public String avatar;

    /**
     * No args constructor for use in serialization
     *
     */
    public UserPost() {
    }

    /**
     *
     * @param firstName
     * @param lastName
     * @param id
     * @param avatar
     * @param email
     */
    public UserPost(String email, String firstName, String lastName, String avatar) {
        super();
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.avatar = avatar;
    }

}