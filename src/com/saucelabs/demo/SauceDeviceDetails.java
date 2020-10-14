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
public class SauceDeviceDetails {

    @JsonProperty("EU")
    private List<DeviceFullDetails> eU = null;
    @JsonProperty("US")
    private List<DeviceFullDetails> uS = null;

    public SauceDeviceDetails() {
        super();
    }

    /**
     *
     * @param eU
     * @param uS
     */
    public SauceDeviceDetails(List<DeviceFullDetails> eU, List<DeviceFullDetails> uS) {
        super();
        this.eU = eU;
        this.uS = uS;
    }

    @JsonProperty("EU")
    public List<DeviceFullDetails> getEU() {
        return eU;
    }

    @JsonProperty("US")
    public List<DeviceFullDetails> getUS() {
        return uS;
    }
}