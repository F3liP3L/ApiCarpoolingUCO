package co.edu.uco.carpooling.infrastructure.adapter.route.googlemaps;

import co.edu.uco.carpooling.crosscutting.exception.CarpoolingCustomException;
import co.edu.uco.carpooling.service.domain.RouteDomain;
import co.edu.uco.carpooling.service.model.Position;
import co.edu.uco.carpooling.service.port.route.ServiceRoutePort;
import com.google.maps.DirectionsApi;
import com.google.maps.GeoApiContext;
import com.google.maps.errors.ApiException;
import com.google.maps.model.DirectionsResult;
import com.google.maps.model.TravelMode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@Slf4j
public class ServiceRouteGoogleMapsAdapter {
    @Autowired
    private GeoApiContext geoApiContext;

    /*@Override
    public RouteDomain buildRoute(Position origin, Position destination) {
        String init = "6.140721660574046, -75.37787894157424";
        String destino = "6.1430684560336495, -75.37256816816605";
        log.info(buildRouteService(init, destino).toString());
        return RouteDomain.build();
    }*/

    private DirectionsResult buildRouteService(String init, String destination) {
        DirectionsResult result = new DirectionsResult();
        try {
            result = DirectionsApi.newRequest(geoApiContext)
                    .mode(TravelMode.DRIVING) // Configura que solo aplique para vehiculos.
                    .origin(init)
                    .destination(destination)
                    .await();
        } catch (CarpoolingCustomException | ApiException | IOException exception) {
            exception.printStackTrace();
            throw CarpoolingCustomException.buildTechnicalException("An error occurred while trying to create the route using the google maps service.");
        } catch (InterruptedException exception) {
            Thread.currentThread().interrupt();
        }
        return result;
    }
}
