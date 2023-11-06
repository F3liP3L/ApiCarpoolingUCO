package co.edu.uco.carpooling.service.usecase.route.implementation;

import co.edu.uco.carpooling.crosscutting.exception.CarpoolingCustomException;
import co.edu.uco.carpooling.dto.RouteDTO;
import co.edu.uco.carpooling.entity.RouteEntity;
import co.edu.uco.carpooling.service.assembler.entity.EntityAssembler;
import co.edu.uco.carpooling.service.domain.RouteDomain;
import co.edu.uco.carpooling.service.port.repository.RouteRepository;
import co.edu.uco.carpooling.service.usecase.route.ListRouteUseCase;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@Slf4j
public class GetActivateRouteUseCaseImpl implements ListRouteUseCase {
    @Autowired
    private RouteRepository routeRepository;
    @Autowired
    private EntityAssembler<RouteEntity,RouteDomain, RouteDTO> entityAssembler;
    @Override
    public List<RouteDTO> execute(Optional<RouteDTO> dto) {
        List<RouteEntity> routeEntities = routeRepository.findActivateRouteByStatus();
        List<RouteDTO> routes = routeEntities.stream().map(route -> entityAssembler.assembleDTO(route)).toList();
        /*try {
            route.setPositions(mapperJson.execute(response.get().getPositions(), new TypeReference<>() {}));
        } catch (JsonProcessingException exception) {
            throw CarpoolingCustomException.buildTechnicalException(exception.getMessage());
        }*/
        log.info(routeEntities.toString());
        return routes;
    }
}
