package co.edu.uco.carpooling.infrastructure.adapter.repository;

import co.edu.uco.carpooling.entity.PointOfInterestEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PointOfInterestRepository extends JpaRepository<PointOfInterestEntity, UUID> {
}
