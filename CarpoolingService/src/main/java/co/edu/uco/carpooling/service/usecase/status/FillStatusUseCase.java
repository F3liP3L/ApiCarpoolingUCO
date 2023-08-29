package co.edu.uco.carpooling.service.usecase.status;

import co.edu.uco.carpooling.dto.StatusDTO;
import co.edu.uco.carpooling.service.domain.StatusDomain;
import co.edu.uco.carpooling.service.usecase.UseCaseList;

import java.util.List;

public interface FillStatusUseCase extends UseCaseList<StatusDTO> {
    List<StatusDTO> execute();
}
