package co.edu.uco.carpooling.service.usecase.route.implementation;

import co.edu.uco.carpooling.crosscutting.exception.CarpoolingCustomException;
import co.edu.uco.carpooling.crosscutting.util.json.UtilMapperJson;
import co.edu.uco.carpooling.dto.RouteDTO;
import co.edu.uco.carpooling.entity.RouteEntity;
import co.edu.uco.carpooling.service.assembler.entity.EntityAssembler;
import co.edu.uco.carpooling.service.domain.RouteDomain;
import co.edu.uco.carpooling.service.port.repository.RouteRepository;
import co.edu.uco.carpooling.service.specification.implementation.route.ValidRouteSpecification;
import co.edu.uco.carpooling.service.usecase.route.RegisterRouteUseCase;
import co.edu.uco.crosscutting.exception.GeneralException;
import co.edu.uco.crosscutting.util.UtilUUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class RegisterRouteUseCaseImpl implements RegisterRouteUseCase {
    @Autowired
    private EntityAssembler<RouteEntity, RouteDomain, RouteDTO> entityAssembler;
    @Autowired
    private RouteRepository routeRepository;
    @Autowired
    private UtilMapperJson mapper;
    @Autowired
    private ValidRouteSpecification specification;

    @Override
    public void execute(RouteDomain domain) {
        try {
            RouteEntity route = entityAssembler.assembleEntity(domain);
            route.getRouteStatus().setId(UtilUUID.getStringToUUID("12b8b3e4-c10a-4018-9e90-8d3b475c2cef"));
            //route.getPointOfInterest().forEach(point -> point.setId(UtilUUID.getUtilUUID().getNewUUID()));
            Optional<String> response = mapper.execute(domain.getPositions());
            response.ifPresent(route::setPositions);
            //specification.isSatisfyBy(domain);
            routeRepository.save(route);
        } catch (CarpoolingCustomException exception) {
            log.error(exception.getUserMessage());
            throw exception;
        } catch (GeneralException exception) {
            log.error(exception.getUserMessage());
            throw CarpoolingCustomException.build("An unexpected error occurred while trying to register the route", "Unexpected error occurred in the use case of register route ".concat(exception.getMessage()), exception);
        }
    }
}
