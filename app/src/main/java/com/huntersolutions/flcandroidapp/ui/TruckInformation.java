package com.huntersolutions.flcandroidapp.ui;

public class TruckInformation {

    private String deliveryDestination;
    private String deliveryOrigin;
    private String driverName;
    private Double elapsedRealtimeNanos;
    private String TruckName;
    private String Email;
    private boolean hasDelivery;
    private double latitude;
    private double longitude;
    private double time;

    public String getDeliveryDestination() {
        return deliveryDestination;
    }

    public void setDeliveryDestination(String deliveryDestination) {
        this.deliveryDestination = deliveryDestination;
    }

    public String getDeliveryOrigin() {
        return deliveryOrigin;
    }

    public void setDeliveryOrigin(String deliveryOrigin) {
        this.deliveryOrigin = deliveryOrigin;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        switch (driverName) {
            case "michaelfrancisco64@gmail.com":
                this.driverName = "420";
            default:
                throw new IllegalStateException("Unexpected value: " + Email);
        }
    }

    public Double getElapsedRealtimeNanos() {
        return elapsedRealtimeNanos;
    }

    public void setElapsedRealtimeNanos(Double elapsedRealtimeNanos) {
        this.elapsedRealtimeNanos = elapsedRealtimeNanos;
    }

    public String getTruckName() {
        return TruckName;
    }

    public void setTruckName(String truckName) {
        TruckName = truckName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public boolean isHasDelivery() {
        return hasDelivery;
    }

    public void setHasDelivery(boolean hasDelivery) {
        this.hasDelivery = hasDelivery;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }
}
