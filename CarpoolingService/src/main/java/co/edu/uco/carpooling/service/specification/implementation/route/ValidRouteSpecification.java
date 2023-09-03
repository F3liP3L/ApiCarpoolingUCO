package co.edu.uco.carpooling.service.specification.implementation.route;

import co.edu.uco.carpooling.service.domain.RouteDomain;
import co.edu.uco.carpooling.service.specification.CompositeSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidRouteSpecification extends CompositeSpecification<RouteDomain> {
    @Autowired
    private RouteNotDefaultAndInvalidIdSpecification notDefaultAndInvalid;
    @Autowired
    private RouteNotExistSpecification notExistSpecification;

    @Override
    public boolean isSatisfyBy(RouteDomain object) {
        return notDefaultAndInvalid.and(notExistSpecification).isSatisfyBy(object);
    }
}
