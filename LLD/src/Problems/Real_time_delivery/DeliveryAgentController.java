package Problems.Real_time_delivery;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/agents")
public class DeliveryAgentController {

    @Autowired
    private LocationService locationService;

    @PostMapping("/{agentId}/location")
    public ResponseEntity<String> updateLocation(
            @PathVariable String agentId,
            @RequestBody LocationRequest request) {
        if (request.getLatitude() == null || request.getLongitude() == null || request.getOrderId() == null) {
            return ResponseEntity.badRequest().body("Missing required fields");
        }

        locationService.updateLocation(agentId, request);
        return ResponseEntity.ok("Location updated successfully");
    }

    @GetMapping("/{agentId}/location")
    public ResponseEntity<Location> getLocation(@PathVariable String agentId) {
        Location location = locationService.getLocation(agentId);
        if (location == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(location);
    }

}
