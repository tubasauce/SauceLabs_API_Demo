package com.saucelabs.demo;
import java.io.IOException;
import java.util.List;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SauceLabsDeviceAPIJSONParser {
    //convert JSON into List of Objects
    static public <T> List<T> convertAvailableDevicesJSON2List(String region, String json, TypeReference<List<T>> var) throws JsonParseException, JsonMappingException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        AvailableSauceDevices Devices = mapper.readValue(json, AvailableSauceDevices.class);
        List<String> rtnDevices = null;
        if (region.equals("EU")) {
            rtnDevices = Devices.getEU();
            System.out.println("** number of available EU devices: " + rtnDevices.size());
        } else if (region.equals("US")) {
            rtnDevices = Devices.getUS();
            System.out.println("** number of available US devices: " + rtnDevices.size());
        }

        return (List<T>) rtnDevices;
    }

    static public <T> List<T> convertDeviceDetailsJSON2List(String region, String json, TypeReference<List<T>> var) throws JsonParseException, JsonMappingException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        SauceDeviceDetails details = mapper.readValue(json, SauceDeviceDetails.class);
        List<DeviceFullDetails> detailsList = null;
        if (region.equals("EU")) {
            detailsList = details.getEU();
            System.out.println("** full number of available EU devices: " + detailsList.size());
        } else if (region.equals("US")) {
            detailsList = details.getUS();
            System.out.println("** full number of available US devices: " + detailsList.size());
        }

        return (List<T>) detailsList;
    }
}