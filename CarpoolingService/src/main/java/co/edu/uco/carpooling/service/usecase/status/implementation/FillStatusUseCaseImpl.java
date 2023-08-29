package co.edu.uco.carpooling.service.usecase.status.implementation;

import co.edu.uco.carpooling.crosscutting.exception.CarpoolingCustomException;
import co.edu.uco.carpooling.dto.StatusDTO;
import co.edu.uco.carpooling.entity.StatusEntity;
import co.edu.uco.carpooling.infrastructure.adapter.repository.postgressql.StatusRepositoryPostgresSQL;
import co.edu.uco.carpooling.service.assembler.entity.EntityAssembler;
import co.edu.uco.carpooling.service.domain.StatusDomain;
import co.edu.uco.carpooling.service.usecase.status.FillStatusUseCase;
import co.edu.uco.crosscutting.exception.GeneralException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FillStatusUseCaseImpl implements FillStatusUseCase {
    @Autowired
    private StatusRepositoryPostgresSQL statusRepository;
    @Autowired
    private EntityAssembler<StatusEntity, StatusDomain, StatusDTO> entityAssembler;

    @Override
    public List<StatusDTO> execute() {
        try {
            return statusRepository.findAll().stream().map(entity -> entityAssembler.assembleDTO(entity)).toList();
        } catch (CarpoolingCustomException exception) {
            throw exception;
        } catch (GeneralException exception) {
            throw CarpoolingCustomException.buildTechnicalException("An error occurred while trying to query the status informatión.");
        }

    }

    @Override
    public List<StatusDTO> execute(Optional<StatusDTO> dto) {
        return new ArrayList<>();
    }
}
