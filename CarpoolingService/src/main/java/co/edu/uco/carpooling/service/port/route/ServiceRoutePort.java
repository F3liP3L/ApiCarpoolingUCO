package co.edu.uco.carpooling.service.port.route;

import co.edu.uco.carpooling.service.domain.RouteDomain;
import co.edu.uco.carpooling.service.model.Position;

public interface ServiceRoutePort {
    RouteDomain buildRoute(Position positionInit, Position positionFinal);
}
