package com.huntersolutions.flcandroidapp.ui;

public class TruckInformation {

    static String deliveryDestination;
    static String deliveryOrigin;
    static String driverName;
    static Double elapsedRealtimeNanos;
    static String TruckName;
    static String Email;
    static boolean hasDelivery;
    static double latitude;
    static double longitude;
    static double time;
    static double destinationLatitude;
    static double originLatitude;
    static double destinationLongitude;
    static double originLongitude;

    public static double getDestinationLatitude() {
        return destinationLatitude;
    }

    public static void setDestinationLatitude(double destinationLatitude) {
        destinationLatitude = destinationLatitude;
    }

    public static double getOriginLatitude() {
        return originLatitude;
    }

    public static void setOriginLatitude(double originLatitude) {
        originLatitude = originLatitude;
    }

    public static double getDestinationLongitude() {
        return destinationLongitude;
    }

    public static void setDestinationLongitude(double destinationLongitude) {
        destinationLongitude = destinationLongitude;
    }

    public static double getOriginLongitude() {
        return originLongitude;
    }

    public static void setOriginLongitude(double originLongitude) {
        originLongitude = originLongitude;
    }

    public static String getDeliveryDestination() {
        return deliveryDestination;
    }

    public static void setDeliveryDestination(String deliveryDestination) {
        deliveryDestination = deliveryDestination;
    }

    public static String getDeliveryOrigin() {
        return deliveryOrigin;
    }

    public static void setDeliveryOrigin(String deliveryOrigin) {
        deliveryOrigin = deliveryOrigin;
    }

    public static String getDriverName() {
        return driverName;
    }

    public static void setDriverName(String driverName) {
        driverName = driverName;
    }

    public static Double getElapsedRealtimeNanos() {
        return elapsedRealtimeNanos;
    }

    public static void setElapsedRealtimeNanos(Double elapsedRealtimeNanos) {
        elapsedRealtimeNanos = elapsedRealtimeNanos;
    }

    public static String getTruckName() {
        return TruckName;
    }

    public static void setTruckName(String truckName) {
        switch (truckName) {
            case "michaelfrancisco64@gmail.com":
                TruckName = "420";
        }
    }

    public static String getEmail() {
        return Email;
    }

    public static void setEmail(String email) {
        Email = email;
    }

    public static boolean isHasDelivery() {
        return hasDelivery;
    }

    public static void setHasDelivery(boolean hasDelivery) {
        hasDelivery = hasDelivery;
    }

    public static double getLatitude() {
        return latitude;
    }

    public static void setLatitude(double latitude) {
        latitude = latitude;
    }

    public static double getLongitude() {
        return longitude;
    }

    public static void setLongitude(double longitude) {
        longitude = longitude;
    }

    public static double getTime() {
        return time;
    }

    public static void setTime(double time) {
        time = time;
    }
}
