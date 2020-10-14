package com.saucelabs.demo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "abiType",
        "apiLevel",
        "cpuCores",
        "cpuFrequency",
        "defaultOrientation",
        "disableMtp",
        "dpi",
        "hasOnScreenButtons",
        "id",
        "internalOrientation",
        "internalStorageSize",
        "isArm",
        "isKeyGuardDisabled",
        "isPrivate",
        "isRooted",
        "isTablet",
        "manufacturer",
        "modelNumber",
        "name",
        "os",
        "osVersion",
        "pixelsPerPoint",
        "ramSize",
        "resolutionHeight",
        "resolutionWidth",
        "screenSize",
        "sdCardSize",
        "supportsAppiumWebAppTesting",
        "supportsGlobalProxy",
        "supportsMinicapSocketConnection",
        "supportsMockLocations",
        "cpuType",
        "deviceFamily",
        "dpiName",
        "isAlternativeIoEnabled",
        "supportsManualWebTesting",
        "supportsMultiTouch",
        "supportsXcuiTest"
})
public class DeviceFullDetails {

    public DeviceFullDetails() {
        super();
    }

    @JsonProperty("abiType")
    private String abiType;
    @JsonProperty("apiLevel")
    private Integer apiLevel;
    @JsonProperty("cpuCores")
    private Integer cpuCores;
    @JsonProperty("cpuFrequency")
    private Integer cpuFrequency;
    @JsonProperty("defaultOrientation")
    private String defaultOrientation;
    @JsonProperty("disableMtp")
    private Boolean disableMtp;
    @JsonProperty("dpi")
    private Integer dpi;
    @JsonProperty("hasOnScreenButtons")
    private Boolean hasOnScreenButtons;
    @JsonProperty("id")
    private String id;
    @JsonProperty("internalOrientation")
    private String internalOrientation;
    @JsonProperty("internalStorageSize")
    private Integer internalStorageSize;
    @JsonProperty("isArm")
    private Boolean isArm;
    @JsonProperty("isKeyGuardDisabled")
    private Boolean isKeyGuardDisabled;
    @JsonProperty("isPrivate")
    private Boolean isPrivate;
    @JsonProperty("isRooted")
    private Boolean isRooted;
    @JsonProperty("isTablet")
    private Boolean isTablet;
    @JsonProperty("manufacturer")
    private List<String> manufacturer = null;
    @JsonProperty("modelNumber")
    private String modelNumber;
    @JsonProperty("name")
    private String name;
    @JsonProperty("os")
    private String os;
    @JsonProperty("osVersion")
    private String osVersion;
    @JsonProperty("pixelsPerPoint")
    private Integer pixelsPerPoint;
    @JsonProperty("ramSize")
    private Integer ramSize;
    @JsonProperty("resolutionHeight")
    private Integer resolutionHeight;
    @JsonProperty("resolutionWidth")
    private Integer resolutionWidth;
    @JsonProperty("screenSize")
    private Double screenSize;
    @JsonProperty("sdCardSize")
    private Integer sdCardSize;
    @JsonProperty("supportsAppiumWebAppTesting")
    private Boolean supportsAppiumWebAppTesting;
    @JsonProperty("supportsGlobalProxy")
    private Boolean supportsGlobalProxy;
    @JsonProperty("supportsMinicapSocketConnection")
    private Boolean supportsMinicapSocketConnection;
    @JsonProperty("supportsMockLocations")
    private Boolean supportsMockLocations;
    @JsonProperty("cpuType")
    private String cpuType;
    @JsonProperty("deviceFamily")
    private String deviceFamily;
    @JsonProperty("dpiName")
    private String dpiName;
    @JsonProperty("isAlternativeIoEnabled")
    private Boolean isAlternativeIoEnabled;
    @JsonProperty("supportsManualWebTesting")
    private Boolean supportsManualWebTesting;
    @JsonProperty("supportsMultiTouch")
    private Boolean supportsMultiTouch;
    @JsonProperty("supportsXcuiTest")
    private Boolean supportsXcuiTest;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("abiType")
    public String getAbiType() {
        return abiType;
    }

    @JsonProperty("apiLevel")
    public Integer getApiLevel() {
        return apiLevel;
    }

    @JsonProperty("cpuCores")
    public Integer getCpuCores() {
        return cpuCores;
    }

    @JsonProperty("cpuFrequency")
    public Integer getCpuFrequency() {
        return cpuFrequency;
    }

    @JsonProperty("defaultOrientation")
    public String getDefaultOrientation() {
        return defaultOrientation;
    }

    @JsonProperty("disableMtp")
    public Boolean getDisableMtp() {
        return disableMtp;
    }

    @JsonProperty("dpi")
    public Integer getDpi() {
        return dpi;
    }

    @JsonProperty("hasOnScreenButtons")
    public Boolean getHasOnScreenButtons() {
        return hasOnScreenButtons;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("internalOrientation")
    public String getInternalOrientation() {
        return internalOrientation;
    }

    @JsonProperty("internalStorageSize")
    public Integer getInternalStorageSize() {
        return internalStorageSize;
    }

    @JsonProperty("isArm")
    public Boolean getIsArm() {
        return isArm;
    }

    @JsonProperty("isKeyGuardDisabled")
    public Boolean getIsKeyGuardDisabled() {
        return isKeyGuardDisabled;
    }

    @JsonProperty("isPrivate")
    public Boolean getIsPrivate() {
        return isPrivate;
    }

    @JsonProperty("isRooted")
    public Boolean getIsRooted() {
        return isRooted;
    }

    @JsonProperty("isTablet")
    public Boolean getIsTablet() {
        return isTablet;
    }

    @JsonProperty("manufacturer")
    public List<String> getManufacturer() {
        return manufacturer;
    }

    @JsonProperty("modelNumber")
    public String getModelNumber() {
        return modelNumber;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("os")
    public String getOs() {
        return os;
    }

    @JsonProperty("osVersion")
    public String getOsVersion() {
        return osVersion;
    }

    @JsonProperty("pixelsPerPoint")
    public Integer getPixelsPerPoint() {
        return pixelsPerPoint;
    }

    @JsonProperty("ramSize")
    public Integer getRamSize() {
        return ramSize;
    }

    @JsonProperty("resolutionHeight")
    public Integer getResolutionHeight() {
        return resolutionHeight;
    }

    @JsonProperty("resolutionWidth")
    public Integer getResolutionWidth() {
        return resolutionWidth;
    }

    @JsonProperty("screenSize")
    public Double getScreenSize() {
        return screenSize;
    }

    @JsonProperty("sdCardSize")
    public Integer getSdCardSize() {
        return sdCardSize;
    }

    @JsonProperty("supportsAppiumWebAppTesting")
    public Boolean getSupportsAppiumWebAppTesting() {
        return supportsAppiumWebAppTesting;
    }

    @JsonProperty("supportsGlobalProxy")
    public Boolean getSupportsGlobalProxy() {
        return supportsGlobalProxy;
    }

    @JsonProperty("supportsMinicapSocketConnection")
    public Boolean getSupportsMinicapSocketConnection() {
        return supportsMinicapSocketConnection;
    }

    @JsonProperty("supportsMockLocations")
    public Boolean getSupportsMockLocations() {
        return supportsMockLocations;
    }

    @JsonProperty("cpuType")
    public String getCpuType() {
        return cpuType;
    }

    @JsonProperty("deviceFamily")
    public String getDeviceFamily() {
        return deviceFamily;
    }

    @JsonProperty("dpiName")
    public String getDpiName() {
        return dpiName;
    }

    @JsonProperty("isAlternativeIoEnabled")
    public Boolean getIsAlternativeIoEnabled() {
        return isAlternativeIoEnabled;
    }

    @JsonProperty("supportsManualWebTesting")
    public Boolean getSupportsManualWebTesting() {
        return supportsManualWebTesting;
    }

    @JsonProperty("supportsMultiTouch")
    public Boolean getSupportsMultiTouch() {
        return supportsMultiTouch;
    }

    @JsonProperty("supportsXcuiTest")
    public Boolean getSupportsXcuiTest() {
        return supportsXcuiTest;
    }
}