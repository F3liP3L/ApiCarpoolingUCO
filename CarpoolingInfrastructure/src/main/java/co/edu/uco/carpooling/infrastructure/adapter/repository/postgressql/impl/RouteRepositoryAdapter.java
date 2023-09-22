package co.edu.uco.carpooling.infrastructure.adapter.repository.postgressql.impl;

import co.edu.uco.carpooling.entity.RouteEntity;
import co.edu.uco.carpooling.infrastructure.adapter.repository.postgressql.RouteRepositoryPostgresSQL;
import co.edu.uco.carpooling.service.port.repository.RouteRepository;
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
    public List<RouteEntity> findByDriverVehicleIdAndRouteStatusId(UUID driverId, UUID statusId) {
        return routeRepositoryPostgresSQL.findByDriverAndStatus(driverId,statusId);
    }
}
