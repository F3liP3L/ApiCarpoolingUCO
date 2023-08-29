package co.edu.uco.carpooling.service.usecase.route.implementation;

import co.edu.uco.carpooling.crosscutting.exception.CarpoolingCustomException;
import co.edu.uco.carpooling.dto.RouteDTO;
import co.edu.uco.carpooling.entity.RouteEntity;
import co.edu.uco.carpooling.infrastructure.adapter.repository.postgressql.RouteRepositoryPostgresSQL;
import co.edu.uco.carpooling.service.assembler.entity.EntityAssembler;
import co.edu.uco.carpooling.service.assembler.entity.implementation.RouteEntityAssembler;
import co.edu.uco.carpooling.service.domain.RouteDomain;
import co.edu.uco.carpooling.service.usecase.route.RegisterRouteUseCase;
import co.edu.uco.crosscutting.exception.GeneralException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterRouteUseCaseImpl implements RegisterRouteUseCase {
    @Autowired
    private RouteRepositoryPostgresSQL routeRepository;
    @Autowired
    private EntityAssembler<RouteEntity, RouteDomain, RouteDTO> entityAssembler;


    @Override
    public void execute(RouteDomain domain) {
        try {
            RouteEntity routeEntity = entityAssembler.assembleEntity(domain);
            routeRepository.save(routeEntity);
        } catch (CarpoolingCustomException exception) {
            throw exception;
        } catch (GeneralException exception) {
            throw CarpoolingCustomException.buildTechnicalException("An ocurred error trying to created a route");
        }



    }
}
