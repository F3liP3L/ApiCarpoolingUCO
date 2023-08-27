package co.edu.uco.carpooling.service.usecase.pointofinterest.implementation;

import co.edu.uco.carpooling.crosscutting.exception.CarpoolingCustomException;
import co.edu.uco.carpooling.entity.PointOfInterestEntity;
import co.edu.uco.carpooling.infrastructure.adapter.repository.postgressql.PointOfInterestRepositoryPostgresSQL;
import co.edu.uco.carpooling.service.assembler.entity.implementation.PointOfInterestEntityAssembler;
import co.edu.uco.carpooling.service.domain.PointOfInterestDomain;
import co.edu.uco.carpooling.service.usecase.pointofinterest.RegisterPointOfInterestUseCase;
import co.edu.uco.crosscutting.util.UtilUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterPointOfInterestUseCaseImpl implements RegisterPointOfInterestUseCase {

    @Autowired
    private PointOfInterestRepositoryPostgresSQL pointOfInterestRepository;

    @Autowired
    private PointOfInterestEntityAssembler entityAssembler;

    @Override
    public void execute(PointOfInterestDomain domain) {
        try {
            domain.setId(UtilUUID.getUtilUUID().getNewUUID());
            PointOfInterestEntity entity = entityAssembler.assembleEntity(domain);
            pointOfInterestRepository.save(entity);
        } catch (CarpoolingCustomException exception) {
            throw CarpoolingCustomException.build( "An unexpected error trying create point of interest");
        }

    }


}
