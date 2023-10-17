package co.edu.uco.carpooling.infrastructure.adapter.route.googlemaps;

import co.edu.uco.carpooling.crosscutting.exception.CarpoolingCustomException;
import co.edu.uco.carpooling.infrastructure.adapter.route.googlemaps.model.RouteSegment;
import co.edu.uco.carpooling.service.domain.PositionDomain;
import co.edu.uco.carpooling.service.domain.RouteDomain;
import co.edu.uco.carpooling.service.port.route.ServiceRoutePort;
import com.google.maps.DirectionsApi;
import com.google.maps.GeoApiContext;
import com.google.maps.PlacesApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceRouteGoogleMapsAdapter implements ServiceRoutePort {
    @Autowired
    private GeoApiContext geoApiContext;
    @Override
    public RouteDomain buildRoute(PositionDomain origin, PositionDomain destination) {
        String positionOrigin = String.format("%s,%s", origin.getLatitude(), origin.getLongitude());
        String positionDestination = String.format("%s,%s", destination.getLatitude(), destination.getLongitude());
        return buildRouteService(positionOrigin, positionDestination);
    }

    private RouteDomain buildRouteService(String init, String destination) {
        RouteDomain route = new RouteDomain();
        try {
            DirectionsResult result = DirectionsApi.newRequest(geoApiContext)
                    .mode(TravelMode.DRIVING)
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
                    if (route.getPointOfInterest().stream().filter(point -> point.equals(searchResult.name)).findFirst().isEmpty()) {
                        route.getPointOfInterest().add(searchResult.name);
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
