package co.edu.uco.carpooling.service.usecase.route.implementation;

import co.edu.uco.carpooling.crosscutting.exception.CarpoolingCustomException;
import co.edu.uco.carpooling.dto.RouteDTO;
import co.edu.uco.carpooling.entity.RouteEntity;
import co.edu.uco.carpooling.service.assembler.entity.EntityAssembler;
import co.edu.uco.carpooling.service.domain.RouteDomain;
import co.edu.uco.carpooling.service.port.repository.RouteRepository;
import co.edu.uco.carpooling.service.specification.implementation.route.ValidRouteSpecification;
import co.edu.uco.carpooling.service.usecase.route.RegisterRouteUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterRouteUseCaseImpl implements RegisterRouteUseCase {
    @Autowired
    private RouteRepository routeRepository;
    @Autowired
    private EntityAssembler<RouteEntity, RouteDomain, RouteDTO> entityAssembler;
    @Autowired
    private ValidRouteSpecification specification;

    @Override
    public void execute(RouteDomain domain) {
        try {
            RouteEntity routeEntity = entityAssembler.assembleEntity(domain);
            specification.isSatisfyBy(domain);
            routeRepository.save(routeEntity);
        } catch (CarpoolingCustomException exception) {
            throw exception;
        } catch (Exception exception) {
            throw CarpoolingCustomException.build("An unexpected error occurred while trying to register the route", "Unexpected error occurred in the use case of register route ".concat(exception.getMessage()), exception);
        }
    }
}
