package Problems.Real_time_delivery;

import java.time.LocalDateTime;

public class Location {
    private Double latitude;
    private Double longitude;
    private String orderId;
    private LocalDateTime timestamp;

    public Location(Double latitude, Double longitude, String orderId, LocalDateTime timestamp) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.orderId = orderId;
        this.timestamp = timestamp;
    }

    // Getters and Setters
    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
