package com.saucelabs.demo;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpClient.Version;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.Base64;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;

public class SauceLabsDeviceReportAsync {
    private static final HttpClient client = HttpClient.newBuilder().version(Version.HTTP_2).build();
    private static final String serviceURL = "https://app.testobject.com/api/rest/v2";
    private static final String sauce_api_userid = System.getenv("SAUCE_TEAMNAME");
    private static final String sauce_api_access_key = System.getenv("SAUCE_TO_API_KEY");
    private static String encoding = "";
    private static boolean incPhones = true; // isTablet = false
    private static boolean incTablets = false; // isTablet = true
    private static boolean incAndroid = false; // os = Android
    private static boolean incIOS = true; // os = iOS
    private static String iOSVersion = "";  // osversion = ??
    private static String androidVersion = "10"; // osversion = ??
    private static boolean incEU = true;
    private static boolean incUS = true;
    private static boolean privateDevices = false;
    private static List<String> availableDevicesEU = null;
    private static List<String> availableDevicesUS = null;
    private static List<DeviceFullDetails> fullDeviceDetailsEU = null;
    private static List<DeviceFullDetails> fullDeviceDetailsUS = null;

    public static void main(String[] args) throws InterruptedException, ExecutionException, IOException {
        encoding = Base64.getEncoder().encodeToString((sauce_api_userid + ":" + sauce_api_access_key).getBytes("UTF-8"));
        getAllAvailableDevices();
        getDetails4AllDevices();
        filterDevices(availableDevicesEU, availableDevicesUS, fullDeviceDetailsEU, fullDeviceDetailsUS);
    }

    public static void getAllAvailableDevices() throws InterruptedException, ExecutionException, JsonParseException, JsonMappingException, IOException {
        HttpRequest req = HttpRequest.newBuilder(URI.create(serviceURL + "/devices/available"))
                .GET().setHeader("Authorization", "Basic " + encoding).build();

        CompletableFuture<HttpResponse<String>> response = client.sendAsync(req, BodyHandlers.ofString());
        response.thenAccept(res -> System.out.println(res));

        if (incEU) {
            String region = "EU";
            availableDevicesEU = SauceLabsDeviceAPIJSONParser.convertAvailableDevicesJSON2List(region, response.get().body(), new TypeReference<>() {
            });
        }

        if (incUS) {
            String region = "US";
            availableDevicesUS = SauceLabsDeviceAPIJSONParser.convertAvailableDevicesJSON2List(region, response.get().body(), new TypeReference<>() {
            });

            response.join();
        }
    }

    public static void getDetails4AllDevices() throws
            InterruptedException, ExecutionException, JsonParseException, JsonMappingException, IOException {
        HttpRequest req = HttpRequest.newBuilder(URI.create(serviceURL + "/devices"))
                .GET().setHeader("Authorization", "Basic " + encoding).build();

        CompletableFuture<HttpResponse<String>> response = client.sendAsync(req, BodyHandlers.ofString());
        response.thenAccept(res -> System.out.println(res));

        if (incEU) {
            String region = "EU";
            fullDeviceDetailsEU = SauceLabsDeviceAPIJSONParser.convertDeviceDetailsJSON2List(region, response.get().body(), new TypeReference<>() {
            });
        }

        if (incUS) {
            String region = "US";
            fullDeviceDetailsUS = SauceLabsDeviceAPIJSONParser.convertDeviceDetailsJSON2List(region, response.get().body(), new TypeReference<>() {
            });
            //System.out.println("***** US Full Device Details *****");
            //deviceListUS.forEach(item -> System.out.println(item.getId()));
        }

        response.join();
    }

    public static void filterDevices(List<String> availableDevicesEU, List<String> availableDevicesUS, List<DeviceFullDetails> fullDeviceDetailsEU, List<DeviceFullDetails> fullDeviceDetailsUS) {

        boolean includeDevice = false;
        String availableDeviceName = "";
        DeviceFullDetails fullDetails = null;
        String fullDeviceName = "";
        boolean fullDeviceIsTablet = false;
        String fullDeviceOS = null;
        String fullDeviceOSVersion = null;
        int matched = 0;

        if (incEU) {
            for (int i = 0; i < availableDevicesEU.size(); i++) {
                availableDeviceName = availableDevicesEU.get(i);
                for (int j = 0; j < fullDeviceDetailsEU.size(); j++) {
                    includeDevice = false;
                    fullDetails = fullDeviceDetailsEU.get(j);
                    fullDeviceIsTablet = fullDetails.getIsTablet();
                    fullDeviceOS = fullDetails.getOs();
                    fullDeviceOSVersion = fullDetails.getOsVersion();
                    fullDeviceName = fullDetails.getId();

                    if ((incPhones && !fullDeviceIsTablet) || (incTablets && fullDeviceIsTablet)) {
                        if ((incIOS && (fullDeviceOS.equals("IOS"))) || incAndroid && (fullDeviceOS.equals("ANDROID"))) {
                            if (incIOS) {
                                if (iOSVersion.isBlank() || iOSVersion.equals(fullDeviceOSVersion)) {
                                    if (availableDeviceName.equals(fullDeviceName)) {
                                        matched++;
                                        System.out.println("DEVICE " + matched + " MATCHED and filtered: Location: EU, device ID: " + fullDeviceName + ", OS: " + fullDeviceOS + ", OS Version: " + fullDeviceOSVersion + ", Is Tablet? " + fullDeviceIsTablet);
                                        j = fullDeviceDetailsEU.size();
                                }
                            } else if (incAndroid) {
                                if (androidVersion.isBlank() || androidVersion.equals(fullDeviceOSVersion)) {
                                    if (availableDeviceName.equals(fullDeviceName)) {
                                        System.out.println("DEVICE MATCHED and filtered: Location: EU, device ID: " + fullDeviceName + ", OS: " + fullDeviceOS + ", OS Version: " + fullDeviceOSVersion + ", Is Tablet? " + fullDeviceIsTablet);
                                        j = fullDeviceDetailsEU.size();
                                }
                            }
                            }
                            }
                        }
                    }
                }
            }
        }

        if (incUS) {
            for (int i = 0; i < availableDevicesUS.size(); i++) {
                availableDeviceName = availableDevicesUS.get(i);
                for (int j = 0; j < fullDeviceDetailsUS.size(); j++) {
                    includeDevice = false;
                    fullDetails = fullDeviceDetailsUS.get(j);
                    fullDeviceIsTablet = fullDetails.getIsTablet();
                    fullDeviceOS = fullDetails.getOs();
                    fullDeviceOSVersion = fullDetails.getOsVersion();
                    fullDeviceName = fullDetails.getId();

                    if ((incPhones && !fullDeviceIsTablet) || (incTablets && fullDeviceIsTablet)) {
                        if ((incIOS && (fullDeviceOS.equals("IOS"))) || incAndroid && (fullDeviceOS.equals("ANDROID"))) {
                            if (incIOS) {
                                if (iOSVersion.isBlank() || iOSVersion.equals(fullDeviceOSVersion)) {
                                    if (availableDeviceName.equals(fullDeviceName)) {
                                        matched++;
                                        System.out.println("DEVICE " + matched + " MATCHED and filtered: Location: US, device ID: " + fullDeviceName + ", OS: " + fullDeviceOS + ", OS Version: " + fullDeviceOSVersion + ", Is Tablet? " + fullDeviceIsTablet);
                                        j = fullDeviceDetailsUS.size();
                                    }
                                } else if (incAndroid) {
                                    if (androidVersion.isBlank() || androidVersion.equals(fullDeviceOSVersion)) {
                                        if (availableDeviceName.equals(fullDeviceName)) {
                                            System.out.println("DEVICE MATCHED and filtered: Location: US, device ID: " + fullDeviceName + ", OS: " + fullDeviceOS + ", OS Version: " + fullDeviceOSVersion + ", Is Tablet? " + fullDeviceIsTablet);
                                            j = fullDeviceDetailsUS.size();
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

    }

    private class deviceReportDetails {
        
    }
}
