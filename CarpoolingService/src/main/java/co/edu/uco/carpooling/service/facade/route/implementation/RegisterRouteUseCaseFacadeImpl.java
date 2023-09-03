package co.edu.uco.carpooling.service.facade.route.implementation;

import co.edu.uco.carpooling.crosscutting.exception.CarpoolingCustomException;
import co.edu.uco.carpooling.dto.RouteDTO;
import co.edu.uco.carpooling.service.assembler.dto.DTOAssembler;
import co.edu.uco.carpooling.service.domain.RouteDomain;
import co.edu.uco.carpooling.service.facade.route.RegisterRouteUseCaseFacade;
import co.edu.uco.carpooling.service.usecase.route.RegisterRouteUseCase;
import co.edu.uco.crosscutting.exception.GeneralException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RegisterRouteUseCaseFacadeImpl implements RegisterRouteUseCaseFacade {
    @Autowired
    private RegisterRouteUseCase registerRouteUseCase;
    @Autowired
    private DTOAssembler<RouteDomain, RouteDTO> dtoAssembler;

    @Override
    public void execute(RouteDTO dto) {
        try {
            RouteDomain routeDomain = dtoAssembler.assembleDomain(dto);
            registerRouteUseCase.execute(routeDomain);
        } catch (CarpoolingCustomException exception) {
            throw exception;
        } catch (Exception exception) {
            throw exception;
        }


    }
}
