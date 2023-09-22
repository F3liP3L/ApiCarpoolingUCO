package co.edu.uco.carpooling.service.port.repository;

import co.edu.uco.carpooling.entity.StatusEntity;

import java.util.List;

public interface StatusRepository {

    List<StatusEntity> findAll();
}
