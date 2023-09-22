package co.edu.uco.carpooling.infrastructure.adapter.repository.postgressql.impl;

import co.edu.uco.carpooling.entity.CityEntity;
import co.edu.uco.carpooling.infrastructure.adapter.repository.postgressql.CityRepositoryPostgresSQL;
import co.edu.uco.carpooling.service.port.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityRepositoryAdapter implements CityRepository {

    @Autowired
    private CityRepositoryPostgresSQL cityRepositoryPostgresSQL;
    @Override
    public List<CityEntity> findAll() {
        return cityRepositoryPostgresSQL.findAll();
    }
}
