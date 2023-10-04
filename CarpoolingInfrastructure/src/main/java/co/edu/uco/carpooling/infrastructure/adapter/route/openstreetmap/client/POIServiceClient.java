package co.edu.uco.carpooling.infrastructure.adapter.route.openstreetmap.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "poi-service", url = "https://overpass-api.de")
public interface POIServiceClient {
    @GetMapping("/api/interpreter")
    String getPOIsAlongRoute(@RequestParam("data") String query);
}
