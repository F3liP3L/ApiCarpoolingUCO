package co.edu.uco.carpooling.service.specification.implementation.route;

import co.edu.uco.carpooling.service.domain.RouteDomain;
import co.edu.uco.carpooling.service.specification.CompositeSpecification;
import org.springframework.stereotype.Component;

@Component
public class RouteNotDefaultAndInvalidIdSpecification extends CompositeSpecification<RouteDomain> {
    @Override
    public boolean isSatisfyBy(RouteDomain object) {
        return false;
    }
}
