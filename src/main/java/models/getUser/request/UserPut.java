package models.getUser.request;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "name",
        "job"
})
@Generated("jsonschema2pojo")
public class UserPut {

    @JsonProperty("name")
    public String name;
    @JsonProperty("job")
    public String job;

    /**
     * No args constructor for use in serialization
     *
     */
    public UserPut() {
    }

    /**
     *
     * @param name
     * @param job
     */
    public UserPut(String name, String job) {
        super();
        this.name = name;
        this.job = job;
    }

}
