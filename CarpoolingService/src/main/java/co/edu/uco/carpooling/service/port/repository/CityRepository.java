package co.edu.uco.carpooling.service.port.repository;

import co.edu.uco.carpooling.entity.CityEntity;

import java.util.List;

public interface CityRepository {

    List<CityEntity> findAll();

}
