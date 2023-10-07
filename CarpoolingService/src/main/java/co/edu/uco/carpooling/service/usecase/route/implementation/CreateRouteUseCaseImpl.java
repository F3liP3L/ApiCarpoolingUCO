package co.edu.uco.carpooling.service.usecase.route.implementation;

import co.edu.uco.carpooling.service.domain.RouteDomain;
import co.edu.uco.carpooling.service.model.Position;
import co.edu.uco.carpooling.service.port.broker.route.SenderRouteCreatePort;
import co.edu.uco.carpooling.service.port.route.ServiceRoutePort;
import co.edu.uco.carpooling.service.specification.implementation.route.ValidRouteSpecification;
import co.edu.uco.carpooling.service.usecase.route.CreateRouteUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateRouteUseCaseImpl implements CreateRouteUseCase {
    @Autowired
    private ServiceRoutePort serviceRoutePort;
    @Autowired
    private SenderRouteCreatePort senderRouteCreatePort;
    @Autowired
    private ValidRouteSpecification specification;
    @Override
    public void execute(RouteDomain domain) {
        //specification.isSatisfyBy(domain);
        //RouteDomain route = serviceRoutePort.buildRoute(new Position("6.148020365449735","-75.38978436605304"), new Position("6.148472933225518","-75.3716983119229"));
        senderRouteCreatePort.execute(domain, domain.getId().toString());

    }
}
