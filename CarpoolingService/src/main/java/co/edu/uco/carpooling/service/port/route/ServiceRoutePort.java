package co.edu.uco.carpooling.service.port.route;

import co.edu.uco.carpooling.service.domain.PositionDomain;
import co.edu.uco.carpooling.service.domain.RouteDomain;

public interface ServiceRoutePort {
    RouteDomain buildRoute(PositionDomain positionInit, PositionDomain positionFinal);
}
