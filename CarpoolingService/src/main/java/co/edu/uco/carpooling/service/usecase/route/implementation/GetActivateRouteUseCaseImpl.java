package co.edu.uco.carpooling.service.usecase.route.implementation;

import co.edu.uco.carpooling.dto.RouteDTO;
import co.edu.uco.carpooling.entity.RouteEntity;
import co.edu.uco.carpooling.service.assembler.entity.EntityAssembler;
import co.edu.uco.carpooling.service.domain.RouteDomain;
import co.edu.uco.carpooling.service.port.repository.RouteRepository;
import co.edu.uco.carpooling.service.usecase.route.ListRouteUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GetActivateRouteUseCaseImpl implements ListRouteUseCase {

    @Autowired
    private RouteRepository routeRepository;
    @Autowired
    private EntityAssembler<RouteEntity,RouteDomain, RouteDTO> entityAssembler;

    @Override
    public List<RouteDTO> execute(Optional<RouteDTO> dto) {
        return routeRepository.findActivateRouteByStatus().stream().map(routeEntity -> entityAssembler.assembleDTO(routeEntity)).toList();
    }
}
