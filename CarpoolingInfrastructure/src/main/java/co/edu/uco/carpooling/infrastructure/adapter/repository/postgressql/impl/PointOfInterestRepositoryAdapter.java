package co.edu.uco.carpooling.infrastructure.adapter.repository.postgressql.impl;

import co.edu.uco.carpooling.entity.PointOfInterestEntity;
import co.edu.uco.carpooling.infrastructure.adapter.repository.postgressql.PointOfInterestRepositoryPostgresSQL;
import co.edu.uco.carpooling.service.port.repository.PointOfInterestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PointOfInterestRepositoryAdapter implements PointOfInterestRepository {

    @Autowired
    private PointOfInterestRepositoryPostgresSQL pointOfInterestRepositoryPostgresSQL;
    @Override
    public List<PointOfInterestEntity> findAll() {
        return pointOfInterestRepositoryPostgresSQL.findAll();
    }

    @Override
    public void save(PointOfInterestEntity pointOfInterestEntity) {
        pointOfInterestRepositoryPostgresSQL.save(pointOfInterestEntity);
    }
}
