package co.edu.uco.carpooling.infrastructure.adapter.repository.postgressql;

import co.edu.uco.carpooling.entity.RouteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface RouteRepositoryPostgresSQL extends JpaRepository<RouteEntity, UUID> {
    List<RouteEntity> findByDriverVehicleIdAndRouteStatusId(UUID driverId, UUID statusId);

    @Query(value = "SELECT * FROM route r WHERE r.driver_vehicle_id = ?1 AND r.route_status_id =?2", nativeQuery = true)
    List<RouteEntity> findByDriverAndStatus(UUID driverId, UUID statusId);
}

