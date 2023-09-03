package co.edu.uco.carpooling.service.specification.implementation.route;

import co.edu.uco.carpooling.crosscutting.exception.CarpoolingCustomException;
import co.edu.uco.carpooling.service.domain.RouteDomain;
import co.edu.uco.carpooling.service.specification.CompositeSpecification;
import co.edu.uco.crosscutting.util.UtilNumeric;
import co.edu.uco.crosscutting.util.UtilText;
import co.edu.uco.crosscutting.util.UtilUUID;
import org.springframework.stereotype.Component;

@Component
public class RouteNotDefaultAndInvalidIdSpecification extends CompositeSpecification<RouteDomain> {
    @Override
    public boolean isSatisfyBy(RouteDomain object) {
        try {
            return isValid(object);
        } catch (CarpoolingCustomException exception) {
            throw exception;
        }
    }

    private boolean isValid(RouteDomain route) {
        if (UtilNumeric.getUtilNumeric().isEqualThan(route.getRouteCapacity(), UtilNumeric.ZERO)) {
            throw CarpoolingCustomException.buildUserException("The capacity the route no has 0, pd: no pueden haber 0 cupos hermano cojela suave!!");
        }
        if (UtilText.getUtilText().isEmpty(route.getPointOfInterest().getName())) {
            throw CarpoolingCustomException.buildUserException("The PointOfInterest not has register");
        }
        if (UtilUUID.getUtilUUID().getStringFromUUID(route.getId()).length() != 36 || UtilUUID.getUtilUUID().getStringFromUUID(route.getId()).equals(UtilUUID.DEFAULT_UUID_STRING)) {
            throw CarpoolingCustomException.buildUserException("The id the route is default.");
        }
        return true;
    }
}
