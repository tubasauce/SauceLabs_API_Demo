package com.saucelabs.demo;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "EU",
        "US"
})

public class AvailableSauceDevices {

    @JsonProperty("EU")
    private List<String> eU = null;
    @JsonProperty("US")
    private List<String> uS = null;

    public AvailableSauceDevices() {
        super();
    }

    /**
     *
     * @param eU
     * @param uS
     */
    public AvailableSauceDevices(List<String> eU, List<String> uS) {
        super();
        this.eU = eU;
        this.uS = uS;
    }

    @JsonProperty("EU")
    public List<String> getEU() {
        return eU;
    }

    @JsonProperty("US")
    public List<String> getUS() {
        return uS;
    }
}
