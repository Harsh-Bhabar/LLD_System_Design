package Problems.Real_time_delivery;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class LocationService {

    // In-memory storage (replace with database for production)
    private final ConcurrentHashMap<String, Location> locationStore = new ConcurrentHashMap<>();

    public void updateLocation(String agentId, LocationRequest request) {
        Location location = new Location(
                request.getLatitude(),
                request.getLongitude(),
                request.getOrderId(),
                LocalDateTime.now()
        );
        locationStore.put(agentId, location);
    }

    public Location getLocation(String agentId) {
        return locationStore.get(agentId);
    }
}
