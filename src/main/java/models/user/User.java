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
    private Datum datum;
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
     * @param datum
     * @param support
     */
    public User(Datum datum, Support support) {
        super();
        this.datum = datum;
        this.support = support;
    }

    @JsonProperty("data")
    public Datum getData() {
        return datum;
    }

    @JsonProperty("data")
    public void setData(Datum datum) {
        this.datum = datum;
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