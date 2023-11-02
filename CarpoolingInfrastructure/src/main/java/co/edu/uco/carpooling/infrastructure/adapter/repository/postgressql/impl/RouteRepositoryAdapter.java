package co.edu.uco.carpooling.infrastructure.adapter.repository.postgressql.impl;

import co.edu.uco.carpooling.entity.RouteEntity;
import co.edu.uco.carpooling.infrastructure.adapter.repository.postgressql.RouteRepositoryPostgresSQL;
import co.edu.uco.carpooling.service.port.repository.RouteRepository;
import co.edu.uco.crosscutting.util.UtilUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class RouteRepositoryAdapter implements RouteRepository {

    @Autowired
    private RouteRepositoryPostgresSQL routeRepositoryPostgresSQL;
    @Override
    public void save(RouteEntity route) {
        routeRepositoryPostgresSQL.save(route);
    }

    @Override
    public Optional<RouteEntity> findById(UUID id) {
        return routeRepositoryPostgresSQL.findById(id);
    }

    @Override
    public List<RouteEntity> findActivateRouteByStatus() {
        UUID status = UtilUUID.getStringToUUID("12b8b3e4-c10a-4018-9e90-8d3b475c2cef");
        return routeRepositoryPostgresSQL.findRouteEntityByRouteStatus(status);
    }
}
