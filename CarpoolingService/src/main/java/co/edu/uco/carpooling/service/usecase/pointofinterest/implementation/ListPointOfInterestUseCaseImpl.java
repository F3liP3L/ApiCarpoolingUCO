package co.edu.uco.carpooling.service.usecase.pointofinterest.implementation;

import co.edu.uco.carpooling.dto.PointOfInterestDTO;
import co.edu.uco.carpooling.infrastructure.adapter.repository.postgressql.PointOfInterestRepositoryPostgresSQL;
import co.edu.uco.carpooling.service.assembler.entity.implementation.PointOfInterestEntityAssembler;
import co.edu.uco.carpooling.service.usecase.pointofinterest.ListPointOfInterestUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ListPointOfInterestUseCaseImpl implements ListPointOfInterestUseCase {

    @Autowired
    private PointOfInterestRepositoryPostgresSQL pointOfInterestRepository;

    @Autowired
    private PointOfInterestEntityAssembler entityAssembler;

    @Override
    public List<PointOfInterestDTO> execute(Optional<PointOfInterestDTO> dto) {
        return pointOfInterestRepository.findAll().stream().map(entity -> entityAssembler.assembleDTO(entity)).toList();
    }
}
