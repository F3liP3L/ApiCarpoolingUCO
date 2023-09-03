package co.edu.uco.carpooling.service.specification.implementation.route;

import co.edu.uco.carpooling.crosscutting.exception.CarpoolingCustomException;
import co.edu.uco.carpooling.entity.RouteEntity;
import co.edu.uco.carpooling.infrastructure.adapter.repository.postgressql.RouteRepositoryPostgresSQL;
import co.edu.uco.carpooling.service.domain.RouteDomain;
import co.edu.uco.carpooling.service.specification.CompositeSpecification;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Slf4j
public class RouteNotExistSpecification extends CompositeSpecification<RouteDomain> {
    @Autowired
    private RouteRepositoryPostgresSQL repositoryPostgresSQL;

    @Override
    public boolean isSatisfyBy(RouteDomain object) {
        return isExist(object);
    }

    //TODO validar que el conductor por vehiculo solo pueda tener una ruta iniciada.
    private boolean isExist(RouteDomain route) {
        try {
            Optional<RouteEntity> response = repositoryPostgresSQL.findById(route.getId());
            if (response.isPresent()) {
                throw CarpoolingCustomException.buildUserException("The route has exist saramambiche!!");
            }
            return true;
        } catch (CarpoolingCustomException exception) {
            throw exception;
        } catch (Exception exception) {
            throw CarpoolingCustomException.build("The route unexpected error trying to sql has exist!!", exception);
        }

    }
}
