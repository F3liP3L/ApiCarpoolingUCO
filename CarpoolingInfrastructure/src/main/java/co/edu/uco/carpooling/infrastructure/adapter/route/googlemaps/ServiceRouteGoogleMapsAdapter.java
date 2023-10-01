package co.edu.uco.carpooling.infrastructure.adapter.route.googlemaps;

import co.edu.uco.carpooling.crosscutting.exception.CarpoolingCustomException;
import co.edu.uco.carpooling.infrastructure.adapter.route.googlemaps.model.RouteSegment;
import co.edu.uco.carpooling.service.domain.PointOfInterestDomain;
import co.edu.uco.carpooling.service.domain.PositionDomain;
import co.edu.uco.carpooling.service.domain.RouteDomain;
import co.edu.uco.carpooling.service.model.Position;
import co.edu.uco.carpooling.service.port.route.ServiceRoutePort;
import co.edu.uco.crosscutting.util.UtilObject;
import com.google.maps.DirectionsApi;
import com.google.maps.GeoApiContext;
import com.google.maps.PlacesApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class ServiceRouteGoogleMapsAdapter implements ServiceRoutePort {
    @Autowired
    private GeoApiContext geoApiContext;

    @Override
    public RouteDomain buildRoute(Position origin, Position destination) {
        String init = "6.153509802279989, -75.37388989242287";
        String pointFinal = "6.146729079858681, -75.37273744017664";
        String positionOrigin = String.format("%s,%s", origin.getLatitude(), origin.getLongitude());
        return buildRouteService(init, pointFinal);
    }

    private RouteDomain buildRouteService(String init, String destination) {
        RouteDomain route = new RouteDomain();
        try {
            DirectionsResult    result = DirectionsApi.newRequest(geoApiContext)
                    .mode(TravelMode.DRIVING) // Configura que solo aplique para vehiculos.
                    .origin(init)
                    .destination(destination)
                    .await();
            route = RouteDomain.build();

            for (LatLng latLng : result.routes[0].overviewPolyline.decodePath()) {
                    PositionDomain position = new PositionDomain();
                    position.setLatitude(String.valueOf(latLng.lat));
                    position.setLongitude(String.valueOf(latLng.lng));
                    route.getPositions().add(position);
            }

            List<RouteSegment> routeSegments = new ArrayList<>();
            route.getPositions().forEach(pos -> log.info(pos.getLatitude().concat(pos.getLongitude())));

            for (DirectionsStep step : result.routes[0].legs[0].steps) {
                List<LatLng> stepCoordinates = step.polyline.decodePath();
                routeSegments.add(new RouteSegment(stepCoordinates));
            }
            PlacesSearchResponse searchResponse;
            // Busca lugares cercanos a lo largo de la ruta
            for (RouteSegment segment : routeSegments) {
                LatLng midPoint = segment.getMidPoint();

                searchResponse = PlacesApi.nearbySearchQuery(geoApiContext, midPoint)
                        .radius(10) // Radio de búsqueda en metros
                        .await();

                // Procesa los resultados de lugares cercanos.

                for (PlacesSearchResult searchResult : searchResponse.results) {
                    if (route.getPointOfInterest().stream().filter(point -> point.getName().equals(searchResult.name)).findFirst().isEmpty()) {
                        PointOfInterestDomain pointOfInterest = PointOfInterestDomain.build();
                        pointOfInterest.setName(searchResult.name);
                        route.getPointOfInterest().add(pointOfInterest);
                    }
                }
            }
        } catch (CarpoolingCustomException | ApiException | IOException exception) {
            exception.printStackTrace();
            throw CarpoolingCustomException.buildTechnicalException("An error occurred while trying to create the route using the google maps service.");
        } catch (InterruptedException exception) {
            Thread.currentThread().interrupt();
        }
        return route;
    }
}
