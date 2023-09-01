package co.edu.uco.carpooling.service.specification.implementation.route;

import co.edu.uco.carpooling.crosscutting.exception.CarpoolingCustomException;
import co.edu.uco.carpooling.entity.RouteEntity;
import co.edu.uco.carpooling.infrastructure.adapter.repository.postgressql.RouteRepositoryPostgresSQL;
import co.edu.uco.carpooling.service.domain.RouteDomain;
import co.edu.uco.carpooling.service.specification.CompositeSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class RouteNotExistSpecification extends CompositeSpecification<RouteDomain> {
    @Autowired
    private RouteRepositoryPostgresSQL repositoryPostgresSQL;

    @Override
    public boolean isSatisfyBy(RouteDomain object) {
        return false;
    }

    private boolean isExist(RouteDomain route) {
        Optional<RouteEntity> response = repositoryPostgresSQL.findById(route.getId());
        if (response.isEmpty()) {
            throw CarpoolingCustomException.buildUserException("");
        }
        return true;
    }
}
