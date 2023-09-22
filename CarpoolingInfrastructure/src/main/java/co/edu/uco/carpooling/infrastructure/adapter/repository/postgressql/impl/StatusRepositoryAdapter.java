package co.edu.uco.carpooling.infrastructure.adapter.repository.postgressql.impl;

import co.edu.uco.carpooling.entity.StatusEntity;
import co.edu.uco.carpooling.infrastructure.adapter.repository.postgressql.StatusRepositoryPostgresSQL;
import co.edu.uco.carpooling.service.port.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatusRepositoryAdapter implements StatusRepository {

    @Autowired
    private StatusRepositoryPostgresSQL statusRepositoryPostgresSQL;
    @Override
    public List<StatusEntity> findAll() {
        return statusRepositoryPostgresSQL.findAll();
    }
}
