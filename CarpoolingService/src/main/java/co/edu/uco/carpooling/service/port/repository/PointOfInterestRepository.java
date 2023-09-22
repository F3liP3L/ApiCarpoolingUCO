package co.edu.uco.carpooling.service.port.repository;

import co.edu.uco.carpooling.entity.PointOfInterestEntity;

import java.util.List;

public interface PointOfInterestRepository {
    List<PointOfInterestEntity> findAll();
    void save(PointOfInterestEntity pointOfInterestEntity);
}
