package co.edu.uco.carpooling.service.usecase.route.implementation;

import co.edu.uco.carpooling.service.domain.RouteDomain;
import co.edu.uco.carpooling.service.port.broker.route.SenderRouteCreatePort;
import co.edu.uco.carpooling.service.port.route.ServiceRoutePort;
import co.edu.uco.carpooling.service.usecase.route.CreateRouteUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class CreateRouteUseCaseImpl implements CreateRouteUseCase {
    @Qualifier("GoogleMapsAdapter")
    @Autowired
    private ServiceRoutePort serviceRoutePort;
    @Autowired
    private SenderRouteCreatePort senderRouteCreatePort;
    @Override
    public void execute(RouteDomain domain) {
        RouteDomain route = serviceRoutePort.buildRoute(domain.getOrigin(), domain.getDestination());
        domain.setPositions(route.getPositions());
        domain.setPointOfInterest(route.getPointOfInterest());
        senderRouteCreatePort.execute(domain, domain.getId().toString());
    }
}
