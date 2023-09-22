package co.edu.uco.carpooling.service.specification.implementation.route;

import co.edu.uco.carpooling.crosscutting.exception.CarpoolingCustomException;
import co.edu.uco.carpooling.entity.RouteEntity;
import co.edu.uco.carpooling.service.domain.RouteDomain;
import co.edu.uco.carpooling.service.port.repository.RouteRepository;
import co.edu.uco.carpooling.service.specification.CompositeSpecification;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Slf4j
public class RouteExistIdSpecification extends CompositeSpecification<RouteDomain> {
    @Autowired
    private RouteRepository routeRepository;

    @Override
    public boolean isSatisfyBy(RouteDomain object) {
        return isExist(object);
    }

    private boolean isExist(RouteDomain route) {
        try {
            Optional<RouteEntity> routeResponse = routeRepository.findById(route.getId());
            if (routeResponse.isPresent()) {
                throw CarpoolingCustomException.buildUserException("A route with the sent identifier already exists.!!");
            }
            return true;
        } catch (CarpoolingCustomException exception) {
            throw exception;
        } catch (Exception exception) {
            throw CarpoolingCustomException.build("An unexpected error occurred while trying to obtain route information.", exception.getMessage() , exception);
        }

    }
}
